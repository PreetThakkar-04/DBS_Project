
package dbs_project;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.input.KeyCode;

public class general {
    int na,nfds,t=0,ci=0,p,nr=0,g=0;
    int q=0,npk=0,ncxa=0,sk=0;
    String[] attribute;
    ArrayList<ArrayList<String> > xa;
    ArrayList<ArrayList<String> > ya;
    ArrayList<ArrayList<String> > candidatekeys;
    ArrayList<ArrayList<String> > superKeys;
    ArrayList<ArrayList<String>> Relations;
    String[] temp; 
    String[] tep;
    String[] lop;
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
        int siz=na;
        superKeys = new ArrayList<ArrayList<String> >();
        candidatekeys = new ArrayList<ArrayList<String> >();
        while (ncxa<na)
        {
            ncxa++;
            combination(ncxa);
        }
        if (sk==0)
        {
            superKeys.add(new ArrayList<String>());
            for (int i=0;i<na;i++)
            {
                superKeys.get(sk).add(i, attribute[i]);
            }
            sk++;
        }
        for (int i=0;i<sk;i++)
        {
            if (superKeys.get(i).size()<=siz)
            {
                siz=superKeys.get(i).size();
            }
        }
        for (int i=0;i<sk;i++)
        {
            if (superKeys.get(i).size()==siz)
            {
                candidatekeys.add(new ArrayList<String>());
                for (int j=0;j<siz;j++)
                {
                    candidatekeys.get(ci).add(j, superKeys.get(i).get(j));
                }
                ci++;
            }
        }
        return candidatekeys;
    }
    void combination(int k)
    {
        int N = na;
        int pointers[] = new int[k];
        int r=0,i=0;
        while(r >= 0)
        {
		if(i <= (N + (r - k)))
                {
			pointers[r] = i;
			if(r == k-1)
                        {
				collectCombination(pointers,k);
				i++;				
			}
			else
                        {
				i = pointers[r]+1;
				r++;										
			}				
		}
		else
                {
			r--;
			if(r >= 0)
				i = pointers[r]+1;
			
		}			
	}
    }
    void collectCombination(int[] pointers, int k)
    {
        lop = new String[na];
        g=0;
        for (int i=0;i<k;i++)
        {
            lop[g++] = attribute[pointers[i]];
        }
        tempUse();
        if (na==g)
        {
            superKeys.add(new ArrayList<String>());
            for (int i=0;i<k;i++)
            {
                superKeys.get(sk).add(i, attribute[pointers[i]]);
            }
            sk++;
        }
    }
    void tempUse()
    {
        int j=0;
        for (int i=1;i<=g;i++)
        {
            j=tempCombination(i);
            if (j==1)
            {
                break;
            }
        } 
        if (j==1)
            tempUse();
    }
    int tempCombination(int k)
    {
        int N = g,s=0;
        int point[] = new int[k];
        int r=0,i=0;
        while(r >= 0)
        {
		if(i <= (N + (r - k)))
                {
			point[r] = i;
			if(r == k-1)
                        {
				s = collectTemp(point,k);
                                if (s==1)
                                {
                                    return 1;
                                }
				i++;				
			}
			else
                        {
				i = point[r]+1;
				r++;										
			}				
		}
		else
                {
			r--;
			if(r >= 0)
				i = point[r]+1;
			
		}			
	}
        return 0;
    }
    int collectTemp(int [] point, int k)
    {
        int pt = 0,gt=0,ns=0,flg=0;
        String ta[] = new String[k];
        for (int i=0;i<k;i++)
        {
            ta[pt++] = lop[point[i]];
        }
        for (int i=0;i<nfds;i++)
        {
            ns=0;
            int h = xa.get(i).size();
            for (int j=0;j<h;j++)
            {
                for (int z=0;z<pt;z++)
                {
                    if (xa.get(i).get(j).equals(ta[z]))
                        ns++;
                }
            }
            if (ns==h)
            {
                int l = ya.get(i).size();
                for (int j=0;j<l;j++)
                {
                    flg=0;
                    for (int z=0;z<g;z++)
                    {
                        if (ya.get(i).get(j).equals(lop[z]))
                        {
                            flg=1;
                            break;
                        }
                    }
                    if (flg==0)
                   {
                        lop[g++] = ya.get(i).get(j);
                        gt=1;
                   }
                }
            }
            if (gt==1)
                return 1;
        }
        return 0;
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
