

import java.util.ArrayList;

public class Matrix
{
    public double[][] matrix;
    public int length,width;   
    public Matrix(double[][] matrix,int length,int width){
        this.matrix=matrix;
        this.length=length;
        this.width=width;
        deletedColumnsNumber = new ArrayList<Integer>();
        
    }
    public ArrayList<Integer> deletedColumnsNumber;
    public Matrix multiply(Matrix matrix2){

        Smawk smawk= new Smawk();
            double[][] rm=new double[this.length][matrix2.width];
            for(int i=0;i<this.length;i++){
                double[][] mt=new double[matrix2.width][matrix2.length];
                Matrix b= new Matrix(mt,matrix2.width,matrix2.length);
                //����M����
                for(int j=0;j<matrix2.width;j++)
                    for(int k=0;k<matrix2.length;k++){
                        b.matrix[j][k]=this.matrix[i][k]+matrix2.matrix[k][j];
                    }
                System.out.println("�µ��Ӿ�����");
                smawk.printMatrix(b);
                Matrix copyOfb= new Matrix(b.matrix,b.length,b.width);
                ArrayList<Position> positionsOfMaxima= new ArrayList<Position>();                
                positionsOfMaxima=smawk.calculate(copyOfb);
                //Mi�е�x�е����ֵ =>resultMatrix[i][a]
                int count=0;
                for(int x=0;x<positionsOfMaxima.size();x++){
                    rm[i][x]=b.matrix[positionsOfMaxima.get(count).n][positionsOfMaxima.get(count).m];
                    count++;
                }
                
            }
            Matrix resultMatrix= new Matrix(rm,this.length,matrix2.width);
            return resultMatrix;
        }
        

}
