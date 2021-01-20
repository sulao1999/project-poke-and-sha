/*
 * Final_Project.
 * Su Lao
 * 04/07/2020
 */

/* include library */
#include <stdio.h> //C library
#include "a_sulao.h" //include for useful function

#define MAX_SIZE 1048576

//function prototype
unsigned int readFile(unsigned char []);
unsigned int calculateBlocks(unsigned int);
void convertCharArrayToIntArray(unsigned char [], unsigned int [], unsigned int);
void addBitCountToLastBlock(unsigned int [], unsigned int, unsigned int);
void computeMessageDigest(unsigned int [], unsigned int);
unsigned int f(unsigned int, unsigned int, unsigned int, unsigned int);
unsigned int K(unsigned int);

int main(){
   //declare variable 
   unsigned char data[MAX_SIZE] = {'\0'}; // data array
   unsigned char *datapointer = &data[0]; //pointer to data array
   unsigned int message[MAX_SIZE] = {0}; //message
   unsigned int *messagepointer = &message[0]; //pointer to message
   
   
   //readFile
   unsigned int sizeofdata = readFile(datapointer); 
   //printf("%d\n", sizeofdata); //print out the size
   
   //calculateBocks
   unsigned int blockofdata = calculateBlocks(sizeofdata);
   
   //covertCharArrayToArray
   convertCharArrayToIntArray(datapointer, messagepointer, sizeofdata);
   //printf("%d\n", message[0]); //test line
   
   //addBitCountToLastBlock
   addBitCountToLastBlock(messagepointer, sizeofdata, blockofdata);
   
   //computeMessageDigest
   computeMessageDigest(messagepointer, blockofdata);
   
   return 0;
}//close of main

unsigned int readFile(unsigned char buffer[]) {
   //declare variable 
   unsigned int count = 0; 
   char input;
  
   puts("Please use use '< (any name).txt' in the command line to enter the data.");
   puts("or press Ctrl+D after finish input");
   do { //loop to the input
      input = getchar(); //input
      buffer[count] = input; //put input into array
      count++; //increase size count
   } while (EOF != input); //if input is EOF loop end
   count--; //reduce the count by one
   
   buffer[count] = 0x80;
   
   return count; //return the count
} //end readfile

unsigned int calculateBlocks(unsigned int sizeOfFileInBytes) {
   //declare variable
   unsigned int blockCount = 0;
   
   blockCount = (((8 * sizeOfFileInBytes) + 1) / 512) + 1; //equation
   //cheak if a extra block needs to add
   if((((8 * sizeOfFileInBytes) + 1) % 512) > (512 - 64)) {
      blockCount = blockCount + 1;
   }
   
   return blockCount; 
} //end calculateBlocks

void convertCharArrayToIntArray(unsigned char buffer[], 
   unsigned int message[], 
   unsigned int sizeOfFileInBytes) {
   //declare variable
   int i, a, b, c, d;
   int start = 1;
   int x = 0;
   int bytes = sizeOfFileInBytes; //can't use unsigned int for the loop
   
   while (bytes >= 0) { //loop
      i = start * 4; //for the oder
      d = i - 1; //4th
      c = i - 2; //3rd
      b = i - 3; //2nd
      a = i - 4; //1st
      message[x] = charPacker(buffer[a], buffer[b], 
         buffer[c], buffer[d]); //packed 4 char into 1 int
      start++;
      x++;
      bytes = bytes - 4;
   }
   
} //end convertCharArrayToIntArray

void addBitCountToLastBlock(unsigned int message[], 
   unsigned int sizeOfFileInBytes, 
   unsigned int blockCount) {
   
   sizeOfFileInBytes = sizeOfFileInBytes * 8; //8 bits in a byte
   //16 integer array elements in each block
   unsigned int indexOfEndOfLastBlock = (blockCount * 16) - 1;
   //insert the size of the file in bits 
   message[indexOfEndOfLastBlock] = sizeOfFileInBytes;
   
} //end addBitCountToLastBlock

void computeMessageDigest(unsigned int message[], unsigned int blockCount) {
   //initialied H 
   unsigned int H0 = 0x67452301;
   unsigned int H1 = 0xEFCDAB89;
   unsigned int H2 = 0x98BADCFE;
   unsigned int H3 = 0x10325476;
   unsigned int H4 = 0xC3D2E1F0; 
   //declare variable
   int i = 0;
   unsigned int block[blockCount][16];//a
   int x, y, z; //a
   unsigned int tblock[80] = {0};//b
   int t, a, move1, move2, move3, move4; //b
   unsigned int A, B, C, D, E, TEMP; //d
   
   //a
   // split the message in to block with 16 space.
   for(x=0;x<blockCount;x++) {
      z = x * 16;
      for(y=0;y<16;y++) {
         block[x][y] = message[z];
         z++;
      }
   }
   
   while(i < blockCount) {
      for(t=0;t<80;t++) { //b & d
         if(t == 0) {
            for(y=0;y<16;y++) {
               tblock[y] = block[i][y];
            }
         }
         //b
         if(16 <= t && t <=79) {
            a = t;
            move1 = a - 3;
            move2 = a - 8;
            move3 = a - 14;
            move4 = a - 16;
            tblock[t] = (tblock[move1] ^ tblock[move2] ^ tblock[move3] ^ tblock[move4]);
            tblock[t] = circleLeft(1, tblock[t]);
         } //close b
         
         if (t == 0) {
            A = H0;
            B = H1;
            C = H2;
            D = H3;
            E = H4;
         }
         
         //d
         TEMP = circleLeft(5, A) + f(t, B, C, D) + E + tblock[t] + K(t);
         E = D;
         D = C;
         C = circleLeft(30, B);
         B = A;
         A = TEMP;
         
         printf("t = %d: %08X, %08X, %08X, %08X, %08X\n", t, A, B, C, D, E);
      } //close for
      H0 = H0 + A;
      H1 = H1 + B;
      H2 = H2 + C;
      H3 = H3 + D;
      H4 = H4 + E;
      i++;
   }//close wthile
   
   printf("Message digest = %X %X %X %X %X\n", H0, H1, H2, H3, H4);
   
} //end computeMessageDigest

// function f
// C/C++ operator: &  is equivalent to X AND Y = X & Y = bitwise "and" of X and Y
// C/C++ operator: | is equivalent to  X OR Y = X | Y = bitwise "inclusive-or" of X and Y
// C/C++ operator: ^ is equivalent to X XOR Y = X ^ Y = bitwise "exclusive-or" of X and Y
// C/C++ operator: ~ is equivalent to NOT X = ~X = bitwise "complement" of X
// C/C++ operator: + is equivalent to X + Y = 232 modulus addition
unsigned int f(unsigned int t, unsigned int B, unsigned int C, unsigned int D) {
   unsigned int word = 0;
   if (0 <=t && t <= 19) {
      word = (B & C) | ((~B) & D);
   } 
   else if (20 <=t && t <= 39) {
      word = B ^ C ^ D;
   } 
   else if (40 <=t && t <= 59) {
      word = (B & C) | (B & D) | (C & D);
   } 
   else if (60 <=t && t <= 79) {
      word = B ^ C ^ D;
   }
   return word;
}

// function K
unsigned int K(unsigned int t) {
   unsigned int word = 0;
   if (0 <=t && t <= 19) {
      word = 0x5A827999;
   } 
   else if (20 <=t && t <= 39) {
      word = 0x6ED9EBA1;
   } 
   else if (40 <=t && t <= 59) {
      word = 0x8F1BBCDC;
   } 
   else if (60 <=t && t <= 79) {
      word = 0xCA62C1D6;
   }
   return word; 
}