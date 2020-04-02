
package dbs_project;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.input.KeyCode;

public class general {
    int na,nfds,t=0,ci=0,p,nr=0;
    int q=0,npk=0;
    String[] attribute;
    ArrayList<ArrayList<String> > xa;
    ArrayList<ArrayList<String> > ya;
    ArrayList<ArrayList<String> > candidatekeys;
    ArrayList<ArrayList<String>> Relations;
    String[] temp; 
    String[] tep;
    String nf;
    void collectNumberOfAttribute(int num)
    {
        na = num;
        attribute = new String[na];
    }
    void collectAttribute(String[] attri)
    {
        for (int i=0; i<na;i++)
        {
            attribute[i] = attri[i];
        }
    }
    int getNumberOfAttribute()    
    {
      return na;
    }
    String[] getAttributes()
    {
        return attribute;
    }
    void collectNumberOffds(int num)
    {
        nfds = num;
    }
    void collectfds(ArrayList<ArrayList<String> > x,ArrayList<ArrayList<String> > y)
    {
       xa=x;
       ya=y;
    }
    ArrayList<ArrayList<String>> getCandidateKeys()
    {
      temp = new String[na];
      int z=0;
      candidatekeys = new ArrayList<ArrayList<String> >();
      for (int i=0;i<nfds;i++)
      {
          p=0;
          for (int j=0;j<t;j++)
          {
              temp[j]="";
          }
          t=0;
          for (int k=0;k<xa.get(i).size();k++)
          {
              temp[t++] = xa.get(i).get(k);
          }
          for (int j=0;j<nfds;j++)
          {
              if (xa.get(i).equals(xa.get(j)))
              {
                  addTemp(ya.get(j));
              }
          }
          if (t==na)
          {
              for (int k=0;k<ci;k++)
              {
                  if (candidatekeys.get(k).equals(xa.get(i)))
                  {
                      p=1;
                      break;
                  }
              }
              if (p==0)
              {
                    candidatekeys.add(new ArrayList<String>());
                    candidatekeys.add(ci, xa.get(i));
                    ci++;
              }
          }
      }
      if (ci==0)
      {
            candidatekeys.add(new ArrayList<String>());
            for (int k=0;k<na;k++)
            {
                candidatekeys.get(0).add(k, attribute[k]);
            }
            ci++;
      }
      return candidatekeys;
    }
    void addTemp(ArrayList<String> y)
    {
        int size = y.size();
        int w;
        for (int i=0;i<size;i++)
        {
            w=0;
            for (int j=0;j<t;j++)
            {
                if (y.get(i).equals(temp[j]))
                {
                    w=1;  
                    break;
                }
            }
            if (w==0)
            {
                temp[t++] = y.get(i);
            }
        }
    }
    int getNumberOfCandidateKeys()
    {
        return ci;
    }
    boolean checkKeyAttributes(String a)
    {
        for (int i=0;i<ci;i++)
        {
            for (int j=0;j<candidatekeys.get(i).size();j++)
            {
                if (a.equals(candidatekeys.get(i).get(j)))
                    return true;
            }
        }
        return false;
    }
    boolean checkKey(ArrayList<String> a)
    {
        for (int i=0;i<ci;i++)
        {
            if (a.equals(candidatekeys.get(i)))
                return true;
        }
        return false;
    }
    String getNormalForm()
    {
        int flag=0;
        for (int i=0;i<nfds;i++)
        {
            if (!check2NF(i))
                flag=1;
        }
        if (flag==1)
        {
            nf = "1NF";
            return nf;
        }
        for (int i=0;i<nfds;i++)
        {
            if (!check3NF(i))
                flag=1;
        }
        if (flag==1)
        {
            nf = "2NF";
            return nf;
        }
        for (int i=0;i<nfds;i++)
        {
            if (!checkBCNF(i))
                flag=1;
        }
        if (flag==1)
        {
            nf = "3NF";
            return nf;
        }
        nf = "BCNF";
        return nf;
    }
    boolean check2NF(int i)
    {
        for(int j=0;j<ya.get(i).size();j++)
        {
            if (!checkKeyAttributes(ya.get(i).get(j)))
            {
                if (!checkKey(xa.get(i)))
                {
                    for (int k=0;k<xa.get(i).size();k++)
                    {
                        if (checkKeyAttributes(xa.get(i).get(k)))
                            return false;
                    }
                }
            }
        }
        return true;
    }
    boolean check3NF(int i)
    {
        if (checkKey(xa.get(i)))
                return true;
        for (int j=0;j<ya.get(i).size();j++)
        {
            if (checkKeyAttributes(ya.get(i).get(j)))
                return true;
        }
        return false;
    }
    boolean checkBCNF(int i)
    {
        if (checkKey(xa.get(i)))
        {
            return true;
        }
        else
            return false;
    }
    String getNextNormalForm()
    {
        String nnf;
        switch (nf) {
            case "1NF":
                nnf="2NF";
                break;
            case "2NF":
                nnf="3NF";
                break;
            case "3NF":
                nnf="BCNF";
                break;
            default:
                nnf="No further decomposition available";
                break;
        }
        return nnf;
    }
    ArrayList<ArrayList<String>> getDecomposedRelation()
    {
        nr=0;
        Relations = new ArrayList<ArrayList<String> >();
        Relations.add(new ArrayList<String>());
        for (int k=0;k<na;k++)
        {
            Relations.get(0).add(k, attribute[k]);
        }
        nr++;
        if (nf.equals("1NF"))
        {
            for (int i=0;i<nfds;i++)
            {
                oneNFToTwoNF(i);
            }
        }
        else if (nf.equals("2NF"))
        {
            for (int i=0;i<nfds;i++)
            {
                twoNFToThreeNF(i);
            }
        }
        else if (nf.equals("3NF"))
        {
            for (int i=0;i<nfds;i++)
            {
                if (!checkKey(xa.get(i)))
                    threeNFToBCNF(i);
            }
        }
        return Relations;
    }
    void oneNFToTwoNF(int i)
    {
        for(int j=0;j<ya.get(i).size();j++)
            {
                if (!checkKeyAttributes(ya.get(i).get(j)))
                {
                    if (!checkKey(xa.get(i)))
                    {
                        for (int k=0;k<xa.get(i).size();k++)
                        {
                            if (checkKeyAttributes(xa.get(i).get(k)))
                            {
                                newRelation(xa.get(i),ya.get(i).get(k));
                            }
                        }
                    }
                }
            }
    }
    void newRelation(ArrayList<String> xnew,String ynew)
    {
        Relations.add(new ArrayList<String>());
        for (int i=0;i<xnew.size();i++)
        {
            Relations.get(nr).add(i, xnew.get(i));
        }
        Relations.get(nr).add(xnew.size(), ynew);
        nr++;
        for (int i=0;i<na;i++)
        {
            if (ynew.equals(Relations.get(0).get(i)))
            {
                Relations.get(0).remove(i);
                break;
            }
        }
    }
    void twoNFToThreeNF(int i)
    {
        ArrayList<String> ytemp = new ArrayList<String>();
        int s=0;
        if (!checkKey(xa.get(i)))
        {
            for (int j=0;j<ya.get(i).size();j++)
            {
                if (!checkKeyAttributes(ya.get(i).get(j)))
                {
                    ytemp.add(s, ya.get(i).get(j));
                    s++;
                }
            }
            newRelation2(xa.get(i), ytemp);
        }
    }
    void newRelation2(ArrayList<String> xnew, ArrayList<String> ynew)
    {
        Relations.add(new ArrayList<String>());
        int at=0;
        for (int i=0;i<xnew.size();i++)
        {
            Relations.get(nr).add(at, xnew.get(i));
            at++;
        }
        for (int i=0;i<ynew.size();i++)
        {
            Relations.get(nr).add(at, ynew.get(i));
            at++;
        }
        nr++;
       for (int i=0;i<ynew.size();i++)
       {
           Relations.get(0).remove(ynew.get(i));
       }
    }
    void threeNFToBCNF(int i)
    {
        for (int j=0;j<ya.get(i).size();j++)
        {
            newRelation3(xa.get(i),ya.get(i).get(j));
        }
    }
    void newRelation3(ArrayList<String> xnew,String ynew)
    {
        Relations.add(new ArrayList<String>());
        for (int i=0;i<xnew.size();i++)
        {
            Relations.get(nr).add(i, xnew.get(i));
        }
        Relations.get(nr).add(xnew.size(), ynew);
        nr++;
        for (int i=0;i<xnew.size();i++)
        {
            if (ynew.equals(xnew.get(i)))
            {
                break;
            }
            else
            {
                Relations.get(0).remove(ynew);
            }
        }
    }
    int getNumberOfDecomposedRelation()
    {
        return nr;
    }
    ArrayList<ArrayList<String>> getPrimaryKeys()
    {
      ArrayList<ArrayList<String> > pks = new ArrayList<ArrayList<String> >();
      for (int i=0;i<nr;i++)
      {
          tep = new String[na];
          q=0;
          for (int j=0;j<nfds;j++)
          {
                for (int k=0;k<q;k++)
                {
                    tep[k]="";
                }
                q=0;
                for (int k=0;k<xa.get(j).size();k++)
                {
                    tep[q++] = xa.get(j).get(k);
                }
                if (!precomparison(tep,Relations.get(i)))
                {
                    continue;
                }
                for (int k=0;k<nfds;k++)
                {
                    if (xa.get(j).equals(xa.get(k)))
                    {
                        addTep(ya.get(k));
                    }
                }
                if (completecomparison(tep,Relations.get(i)))
                {
                    pks.add(new ArrayList<String>());
                    pks.add(npk, xa.get(j));
                    npk++;
                    break;
                }
          }
          if (npk==0)
          {
                pks.add(new ArrayList<String>());
                for (int k=0;k<Relations.get(i).size();k++)
                {
                    pks.get(0).add(k, Relations.get(i).get(k));
                }
                npk++;
          }
      }
      return pks;
    }
    void addTep(ArrayList<String> y)
    {
        int size = y.size();
        int w;
        for (int i=0;i<size;i++)
        {
            w=0;
            for (int j=0;j<q;j++)
            {
                if (y.get(i).equals(tep[j]))
                {
                    w=1;  
                    break;
                }
            }
            if (w==0)
            {
                tep[q++] = y.get(i);
            }
        }
    }
    boolean precomparison(String[] t,ArrayList<String> r1)
    {
        int d=0;
        for ( int i=0;i<q;i++)
        {
            for (int j=0;j<r1.size();j++)
            {
                if (t[i].equals(r1.get(j)))
                {
                    d++;
                }
            }
        }
        if (d==q)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    boolean completecomparison(String[] t,ArrayList<String> r1)
    {
        int o=0;
        for (int i=0;i<r1.size();i++)
        {
            for (int j=0;j<q;j++)
            {
                if (r1.get(i).equals(t[j]))
                {
                    o++;
                }
            }
        }
        if (o==r1.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
