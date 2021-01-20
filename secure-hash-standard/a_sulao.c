#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "a_sulao.h"

unsigned int charPacker(unsigned char a, unsigned char b, 
   unsigned char c, unsigned char d) {
   /* declare variable */
   unsigned char character[] = {a, b, c, d}; //put into array
   int i = 0; //for loop
   unsigned int result = 0; //result and return value
   int shifter = 8; //shifter
   
   // puts("Output is unsigned integer variable in bit format:");
   for(i=0;i<=3;i++) { //combine all character and shift each one to left
      result = result | character[i]; //combine together 
      if(i !=3) { //last character dont need to shitf.
         result = result << shifter; //shift to left 8 bits.
      } //end if
   } //end for loop
   return result;
} //close charPacker

unsigned int circleLeft(unsigned int shifter, unsigned int integer) {

   int i = 32 - shifter;
   integer = (integer << shifter) | (integer >> i);
   
   return integer;
} //close circleLeft
