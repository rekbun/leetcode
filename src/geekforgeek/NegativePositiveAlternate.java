package geekforgeek;

import com.sun.tools.doclets.internal.toolkit.util.SourceToHTMLConverter;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by rakesh.singh on 25/08/14.
 */
public class NegativePositiveAlternate {
    public int[] transform(int[] input) {
        int outOfPlace =-1;
        for(int i=0;i<input.length;i++) {
            if(outOfPlace>=0 && ( input[i]>0 && input[outOfPlace]<0 || (input[i]<0 && input[outOfPlace]>0))) {
                rightRotate(input,i,outOfPlace);
                if(i-outOfPlace>2) {
                    outOfPlace=outOfPlace+2;
                }else {
                    outOfPlace=-1;
                }
            }

            if(outOfPlace==-1) {
               if((input[i]<0 && i%2==0) ||(input[i]>0 && i%2==1)) {
                    outOfPlace=i;
               }
            }
        }
        return input;
    }

    private void rightRotate(int[] input, int c, int outOfPlace) {
        int temp=input[c];
        for(int i=c;i>outOfPlace;i--) {
            input[i]=input[i-1];
        }
        input[outOfPlace]=temp;
    }

    private void swap(int[] input, int i, int fast) {
        int s = input[i];
        input[i] = input[fast];
        input[fast] = s;
    }

    public void print(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        } 
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, -4, -1, 4};
        NegativePositiveAlternate sol = new NegativePositiveAlternate();
        input = sol.transform(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}
