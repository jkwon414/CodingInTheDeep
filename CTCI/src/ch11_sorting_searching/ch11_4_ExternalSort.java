package ch11_sorting_searching;

public class ch11_4_ExternalSort {
   /**
    * Imagine you have a 20GB file with one string per line. Explain how you would sort the file.
    */

   // split the file into several small blocks, each is below the maximum size of RAM.
   // read each block to RAM, heap sort, then write back to the disk
   // merge all the blocks, one by one.

   // This is known as external sort
   // http://en.wikipedia.org/wiki/External_sorting
}
