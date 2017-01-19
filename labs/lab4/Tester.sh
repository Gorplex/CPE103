#!/bin/bash
printf "Iterations O(1)push O(1)pop\tO(N)push\tO(N)pop\n" > autoReport.txt
echo "-------------------------------------------------------" >> autoReport.txt

base=10000

for i in `seq 0 6`; do
   mult=$((2**$i))
   n=$(($base*$mult))
   printf $mult >> autoReport.txt
   printf "n\t    " >> autoReport.txt 
   printf "%.*f" 0 $(java StackTime push 1 $n) >> autoReport.txt

   printf "ns    " >> autoReport.txt
   printf "%.*f" 0 $(java StackTime pop 1 $n) >> autoReport.txt

   printf "ns\t" >> autoReport.txt
   printf "%.*f" 0 $(java StackTime push N $n) >> autoReport.txt

   printf "ns\t\t" >> autoReport.txt
   printf "%.*f" 0 $(java StackTime pop N $n) >> autoReport.txt
   
   printf "ns\n" >> autoReport.txt
done
