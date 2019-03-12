import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.math.*; 

class Student implements Comparable<Student> {

    private String name;
    private double cgpa;
    private int token;

    public Student(String name, double cgpa,int token) {
        this.name = name;
        this.cgpa = cgpa;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getcgpa() {
        return cgpa;
    }

    public void settoken(int token) {
        this.token = token;
    }
    public double gettoken() {
        return token;
    }

    public void setcgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student Student = (Student) o;
        return Double.compare(Student.cgpa, cgpa) == 0 &&
                Objects.equals(name, Student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cgpa);
    }

    @Override
    public String toString() {
        return name+" ";
    }

    // Compare two Student objects by their cgpa
    @Override
    public int compareTo(Student Student) {
        if(this.getcgpa() < Student.getcgpa()) {
            return 1;
        } else if (this.getcgpa() > Student.getcgpa()) {
            return -1;
        } else {
            ArrayList<String> list = new ArrayList<String>();
            list.add(this.getName());
            list.add(Student.getName());
            Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
              String str = list.get(0);
              if(this.getName().equals(Student.getName()))
              {
                    if(this.gettoken()<Student.gettoken())
                        return 1;
                    else if(this.gettoken()>Student.gettoken())
                        return -1;
              }
            else if(str.equals(this.getName()))
                return -1;
            else if(str.equals(Student.getName()))
                return 1;

            return 0;
        }
    }
}


class Priority {
    public static void main(String[] args) {
    
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>();
        FastScanner cin = new FastScanner(System.in);
        int t = cin.nextInt();
        while(t-->0)
        {
          String st = cin.nextLine();
          
          if(st.equals("SERVED"))
          {
            try
            {studentPriorityQueue.remove();}
            catch(Exception e)
            {
                System.out.println("EMPTY");
            }
          }
          
          else
          {
            String strs[] = st.trim().split("\\s+");
            studentPriorityQueue.add(new Student(strs[1],Double.parseDouble(strs[2]),Integer.parseInt(strs[3])));
          }

        }
        while(!studentPriorityQueue.isEmpty()) 
            System.out.println(studentPriorityQueue.remove());
        }
            static class FastScanner {

        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;
 
        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }
 
        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
 
            return tokenizer.nextToken("\n");
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
         
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
    }
    }

