
package dbs_project;

public class generalHashing {
     int n, bfr, gd, ld,brows;
     int lds[] = new int[1000];
     String[][] buck;
     void collectParameters(int nText, int nBfr, int gdText, int ldText)
     {
         n=nText;
         bfr=nBfr;
         gd=gdText;
         ld=ldText;
         assignLDs();
     }
     void collectGD(int gdText)
     {
         gd=gdText;
     }
     int getN()
     {
         return n;
     }
     int getBfr()
     {
         return bfr;
     }
     int getGD()
     {
         return gd;
     }
     int getLD()
     {
         return ld;
     }
     void assignLDs()
     {
         brows = (int) Math.pow(2, ld);
         for (int i=0;i<brows;i++)
         {
             lds[i] = ld;
         }
     }
     void changeLDs(int rn)
     {
         lds[rn] = lds[rn] +1;
         brows++;
         for (int i=brows-1;i>rn+1;i--)
         {
             lds[i] = lds[i-1];
         }
         lds[rn+1] = lds[rn];
     }
     void collectBucket(String[][] bucket,int b)
     {
         brows = b;
         buck = new String[b][bfr+1];
         for (int i=0;i<b;i++)
         {
             for (int j=0;j<bfr+1;j++)
             {
                 buck[i][j] = bucket[i][j];
             }
         }
     }
     String[][] getBucket()
     {
         return buck;
     }
}
