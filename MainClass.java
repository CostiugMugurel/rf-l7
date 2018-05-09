package rf7;

import java.util.ArrayList;

public class MainClass {
	
	
	public static void main(String[] args) {
		double[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patterns and %s features", numberOfPatterns, numberOfFeatures));
			
			
			ArrayList<double[]> vct = new ArrayList<double[]>();
			vct = FileUtils.centruDeGreutate(learningSet);	
			
			double[] psi = new double[vct.size()];
			
			for(int i=0; i<vct.size();i++)
			{
				double[] temp = new double[3];
				temp = vct.get(i);
				System.out.println(i+1 + " -> " + temp[0] + "  " + temp[1] + "  " + temp[2]);
				psi[i] = temp[0] * 1 + temp[1] * 4 - (temp[0]*temp[0]+temp[1]*temp[1])/2;
				System.out.println("psi(" + i + ") = " + psi[i]);
			}
			
			
			
			
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}
