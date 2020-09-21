import java.util.Scanner;
import java.io.*;

/**
 *   This class creates an image form of an image in color that is read from a 
 *   file. It contains a method to that takes in a colored image and writes out 
 *   an image in greyscale. 
 *   
 *   @version 2018-11-08
 *   @author Frances Adriana Laureano De Leon
 *   
 */

public class PPMImage{

    private int width;
    private int height;
    private int maxShade;
    private String typeOfFile; // here: "P3"
    private short[][][] pixels;


    /**
     *
     *   @param filename - the name of a file that contains an image in 
     *   PPM format of file-type P3.
     *
     *
     */

    public PPMImage(String filename){
    // I write the code I want executed here, just on case it fails due to 
    //  a missing, corrupted, or empty file
    try{

        //the scanner is linked to filename and reads from the file

        Scanner scan = new Scanner(new File(filename));

        // the variables are assigned after the information needed is read from the file

        typeOfFile = scan.next();    
        width = scan.nextInt();
        height = scan.nextInt();
        maxShade = scan.nextInt();

    //  here we need to initialize and read the different pixels, like in Manfred's Example but for a three dimensional array
    //   we do this by making nested loops. Each pixel has its first value for width 
    //   read first, the for height and lastly the three values for color

        pixels = new short[width][height][3];
        for(int i = 0; i < width; i++){
        	for(int j = 0; j < height; j++){
        		for(int k = 0; k < 3; k++){
        			pixels[i][j][k] = scan.nextShort();
                 }
            }
        }
        scan.close(); //closing the scanner
    }
    //  Catch will be sure to make the program continue without crashing 
    //  in case there is no file or there is a corrupted file        
    catch(Exception e){
            System.out.println(e);
            
              typeOfFile = "P3";
              width = 0;
              height = 0;
              maxShade = 0;
              pixels = new short[width][height][0];
        }

    }

    /**
     *  @return the type of file for the image
     */
    public String getTypeOfFile(){
        return typeOfFile;
    }

    /**
     *  @return the width of the image.
     */

    public int getWidth(){
        return width;
    }

    /**
     *  @return the height of the image.
     */
    public int getHeight(){
        return height;
    }

    /**
     *  @return the maximum greyvalue? (not sure what that is for this image)
     *  
     */
    public int getMaxShade(){
        return maxShade;
    }

    /**
     *  @return the 3D array representing the pixels of the image
     */

    public short[][][] getPixels(){
        return pixels;
    }

    /**
     *  This method turns a colored image into a greyscale image
     *  @param the filename of the file that the greay image should be saved as
     */

    public short[][] makeGrey(String filename){
        //  I initialize an array of type short to the number of values for width 
        //  and the number of values for height.

        short[][] image2D = new short[getWidth()][getHeight()];

        //  again here we write the code we would like executed if an image is provided.
        try {

        //  The BufferedWriter will write out the image, first it will write out the 
        //  type of file, the width and height of the file, the maxshade, and the 
        //  pixels of the image represented as a 2D array.

              BufferedWriter out =
              new BufferedWriter(new FileWriter(filename));
              out.write("P2" + "\n"); //  type of file changed from p3 to p2

	          out.write(getWidth() + " " + getHeight() +"\n");
	           
              out.write(getMaxShade() + "\n"); 

            /**
             *  Here we have a loop that has average initialized to zero
             *  It will iterate to find the colored values for each width, height
             *  We do this in order to get the average of the three values
             *  since for every pixel we need only one intensity value for a 
             *  greyscale image. I then assign each width and height as the 
             *  value of average and assign that value to each i,j coordinate
             *  of my array.
             */
             
              short average = 0;
              for(int i = 0; i < getWidth(); i++){
                  for(int j = 0; j < getHeight(); j++){
                      for(int k = 0; k < 3; k++){
                          average += pixels[i][j][k];
                          }
                        average = (short)(average / 3); 
                        image2D[i][j] = average;
                        out.write(image2D[i][j] + " ");
                        average = 0;
                      }
                  }
              out.write("\n");  //  we just simply end on a new line
              out.close();  //  here we close the writer
      }
      catch (IOException e){
          System.out.println("File not found.");
              }
      return image2D; //   I need to return pixels with short[][];
  }

    //  I made a main method to run the program on terminal 

  public static void main(String[] args){    
      PPMImage csBuilding = new PPMImage("ComputerScienceBig.ppm");
      csBuilding.makeGrey("testcs.pgm");
  }

}

// I was unable to figure out how to run Junit tests on this one, and was not able to code it totally until this morning, therefore I was a bit too late to ask for help
//  I am submitting because I worked really hard on it and wish for you to take a look and let me know where I can improve. I will submit Manfred's JUnit tests with this one,
