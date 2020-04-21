
import java.io.*;
import java.util.*;
public class rosalind {


    //GRAPH FUNCTIONS
    public static int vertice(ArrayList<String>s){
        String raw_inst = s.get(0);
        String str_inst[]=raw_inst.split(" ");
        int vertices = Integer.parseInt(str_inst[0]);
        return vertices;
    }
    public static int edge_count(ArrayList<String>s){
        String raw_inst = s.get(0);
        String str_inst[]=raw_inst.split(" ");
        int edge_count = Integer.parseInt(str_inst[1]);
        return edge_count;
    }
    public static int[][] setup_unDirectedADJmatrix(ArrayList<String>s,int vertices, int edge_count){
        int matrix[][] = new int[vertices+1][vertices+1];
        for(int i=1;i<edge_count+1;i++){
            String temp = s.get(i);
            String tp[]= temp.split(" ");
            int a = Integer.parseInt(tp[0]);
            int b = Integer.parseInt(tp[1]);
            matrix[a-1][b-1]=1;
            matrix[b-1][a-1]=1;
        }
        return matrix;
    }
    public static int[][] setup_DirectedADJmatrix(ArrayList<String>s,int vertices, int edge_count){
        int matrix[][] = new int[vertices+1][vertices+1];
        for(int i=1;i<edge_count+1;i++){
            String temp = s.get(i);
            String tp[]= temp.split(" ");
            int a = Integer.parseInt(tp[0]);
            int b = Integer.parseInt(tp[1]);
            matrix[a-1][b-1]=1;
        }
        return matrix;
    }
    public static void print_adjMatrix(int matrix[][],int vertices){
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
    public static  int[][] transPose(int[][] matrix, int vertices){
        int transpose[][] = new int[vertices+1][vertices+1];
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                if(matrix[i][j]==1){
                    transpose[j][i]=1;
                }
            }
        }
        return transpose;
    }
    public static void printMatrix(int matrix[],int n){
        for(int i=0;i<n;i++){
            System.out.printf("%d ",matrix[i]);
        }

    }

    
    //PROBLEM SOLUTIONS
    public static int BinarySearch(int []a,int num){
        int end = a.length;
        int start = 0;
        int midpoint = start + (end-start)/2;
        while(start <=end){
            if(num==a[midpoint]){
                return midpoint+1;
            }
            else if(num > a[midpoint]){
                start = midpoint+1;
            }
            else{
                end = midpoint-1;
            }
            midpoint = start + (end-start)/2;
        }
        return -1;
    }
    public static String BinarySearchFin(ArrayList<String>s){
        String ans="";
        int n= Integer.parseInt(s.get(0));
        int m = Integer.parseInt((s.get(1)));
        int a[]=new int[n];
        int b[]=new int[m];
        String temp1 = s.get(2);
        String q[] = temp1.split(" ");
        String temp2 = s.get(3);
        String w[] = temp2.split(" ");
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(q[i]);
        }
        for(int j=0;j<m;j++){
            b[j]= Integer.parseInt(w[j]);
        }
        for(int k=0;k<m;k++){
            int returnval = BinarySearch(a,b[k]);
            ans+=returnval;
            ans+=" ";
        }
        return ans;
    }
    public static String graphDegree(ArrayList <String>s){
        HashMap<Integer,Integer> degree = new HashMap<>();
        String ins="";
        String graph_Data="";
        graph_Data= s.get(0);
        String Data[]=graph_Data.split(" ");
        int vertices = Integer.parseInt(Data[0]);
        int edges = Integer.parseInt(Data[1]);
        for(int i=1;i<=edges;i++){
            ins=s.get(i);
            String graph[]=ins.split(" ");
            for(int j=0;j<2;j++){
                int vertex = Integer.parseInt(graph[j]);
                if(!degree.containsKey(vertex)){
                    degree.put(vertex,1);
                }
                else{
                    int temp= degree.get(vertex);
                    temp+=1;
                    degree.replace(vertex,temp);
                }
            }
        }
        String ans="";
        for(int i=1;i<=vertices;i++){
            ans+=degree.get(i);
            ans+=" ";
        }
        return ans;
    }
    public static String insertionSort(ArrayList<String>s){
        int counter=0;
        String ans="";
        String size_string = s.get(0);
        String array_string = s.get(1);
        int size=Integer.parseInt(size_string);
        String array[]=array_string.split(" ");
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = Integer.parseInt(array[i]);
        }
        for(int j=1;j<size;j++){
            int k=j;
            while((k>0)&&(a[k]<a[k-1])){
                int temp=a[k-1];
                a[k-1]=a[k];
                a[k]=temp;
                counter+=1;
                k-=1;
            }
        }
        ans+=Integer.toString(counter);
        return ans;
    }
    public static HashMap<Integer,Integer> degree(ArrayList<String>s){
        HashMap<Integer,Integer> degree = new HashMap<>();
        String ins="";
        String graph_Data="";
        graph_Data= s.get(0);
        String Data[]=graph_Data.split(" ");
        int vertices = Integer.parseInt(Data[0]);
        int edges = Integer.parseInt(Data[1]);
        for(int i=1;i<=edges;i++){
            ins=s.get(i);
            String graph[]=ins.split(" ");
            for(int j=0;j<2;j++){
                int vertex = Integer.parseInt(graph[j]);
                if(!degree.containsKey(vertex)){
                    degree.put(vertex,1);
                }
                else{
                    int temp= degree.get(vertex);
                    temp+=1;
                    degree.replace(vertex,temp);
                }
            }
        }
        return degree;
    }
    public static String neighbour(ArrayList<String>s){
        HashMap<Integer,Integer>degrees = new HashMap<>();
        HashMap<Integer,Integer>neighbour = new HashMap<>();
        degrees = degree(s);
        String raw_inst = s.get(0);
        String str_inst[]=raw_inst.split(" ");
        int vertices = Integer.parseInt(str_inst[0]);
        int matrix[][] = new int[vertices+1][vertices+1];
        int edge_count = Integer.parseInt(str_inst[1]);
        for(int i=1;i<edge_count+1;i++){
            String temp = s.get(i);
            String tp[]= temp.split(" ");
            int a = Integer.parseInt(tp[0]);
            int b = Integer.parseInt(tp[1]);
            matrix[a][b]=1;
            matrix[b][a]=1;
        }
        for(int i=0;i<vertices+1;i++){
            for(int j=0;j<vertices+1;j++){
                if(matrix[i][j]==1){
                    if(!neighbour.containsKey(i)){
                        neighbour.put(i,degrees.get(j));
                    }
                    else{
                        int temp=neighbour.get(i);
                        temp+=degrees.get(j);
                        neighbour.replace(i,temp);
                    }
                }
            }
        }
        String ans="";
        for(int i=1;i<vertices+1;i++){
            if(!neighbour.containsKey(i)){
                neighbour.put(i,0);
            }
            ans+=neighbour.get(i);
            ans+=" ";
        }
        return ans;
    }
    public static Integer major(int nums[]){
        int major_index=0;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[major_index] == nums[i]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                major_index=i;
                count=1;
            }
        }
        int candidate = nums[major_index];
        int counter=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate){
                counter+=1;
            }
        }
        if(counter > nums.length/2){
            return nums[major_index];
        }
        else{
            return -1;
        }
    }
    public static String major_element(ArrayList<String>s){
        String raw_inst = s.get(0);
        String ans="";
        String str_inst[]=raw_inst.split(" ");
        int no_arrays = Integer.parseInt(str_inst[0]);
        int array_size= Integer.parseInt(str_inst[1]);
        for(int i=1;i<=no_arrays;i++){
            String temp = s.get(i);
            ArrayList<Integer>res = new ArrayList<>();
            String tp[] = temp.split(" ");
            int nums[]=new int[array_size];
            for(int q=0;q<tp.length;q++){
                nums[q]=Integer.parseInt(tp[q]);
            }
            ans+=Integer.toString(major(nums));
            ans+=" ";
        }
        return ans;
    }
    public static String sortedArray(ArrayList<String>s){
        //DATA GATHERING
        String one=s.get(0);
        String two=s.get(1);
        String three=s.get(2);
        String four=s.get(3);
        int n= Integer.parseInt(one);
        int m=Integer.parseInt(three);
        int a[] = new int[n];
        int b[] = new int[m];
        int o[] = new int[n+m];
        String tres[]=two.split(" ");
        String quater[]=four.split(" ");
        for(int i=0;i<tres.length;i++) {
            a[i] = Integer.parseInt(tres[i]);
        }
        for(int j=0;j<quater.length;j++) {
            b[j] = Integer.parseInt(quater[j]);
        }
        //REAL ALGO
        int r=0;
        int q=0;
        while((r+q)<(m+n)){
            int x=r+q;
            if(q>=m){
                o[x]=a[r];
                break;
            }
            if(r>=n){
                o[x]=b[q];
                break;
            }
            int num=0;
            if(a[r]>b[q]){
                num=b[q];
                q+=1;
            }
            else{
                num=a[r];
                r+=1;
            }
            o[x]=num;
        }
        String ans="";
        for(int i=0;i<n+m;i++){
            ans+=Integer.toString(o[i]);
            ans+=" ";
        }
        return ans;
    }
    public static String inversion(ArrayList<String>s){
        String one= s.get(0);
        String ans="";
        int size=Integer.parseInt(one);
        int a[] = new int[size];
        String two=s.get(1);
        String[]temp =two.split(" ");
        for(int i=0;i<temp.length;i++){
            a[i] = Integer.parseInt(temp[i]);
        }
        int inversion=0;
        for(int j=0;j<size;j++){
            for(int k=j+1;k<size;k++){
                if(a[j]>a[k]){
                    inversion+=1;
                }
            }
        }
        ans+=inversion;
        return ans;
    }
    public static String bfs(ArrayList<String>s){
        String ans="";
        HashMap<Integer,Integer>distance = new HashMap<>();
        Queue<Integer>q = new LinkedList<>();
        int inf = Integer.MAX_VALUE;
        String raw_inst = s.get(0);
        String str_inst[]=raw_inst.split(" ");
        int vertices = Integer.parseInt(str_inst[0]);
        int matrix[][] = new int[vertices+1][vertices+1];
        int edge_count = Integer.parseInt(str_inst[1]);
        for(int i=1;i<edge_count+1;i++){
            String temp = s.get(i);
            String tp[]= temp.split(" ");
            int a = Integer.parseInt(tp[0]);
            int b = Integer.parseInt(tp[1]);
            matrix[a-1][b-1]=1;
        }

        //BFS ALGO
        for(int i=1;i<=vertices;i++){
            distance.put(i,inf);
        }

        distance.replace(1,0);
        q.add(1);
        while (!q.isEmpty()){
            int u = q.remove();
            for(int v=0;v<vertices;v++){
                if(matrix[u-1][v]==1){
                    if(distance.get(v+1) == inf){
                        q.add(v+1);
                        distance.replace(v+1,distance.get(u)+1);
                    }
                }
            }
        }
        int element=1;
        while(!distance.isEmpty()){
            int dis = distance.get(element);
            if(dis==inf){
                ans+=-1;
            }
            else{
                ans+=dis;
            }
            ans+=" ";
            distance.remove(element);
            element+=1;
        }
        return ans;
    }
    public static String connected(ArrayList<String>s){
        int count=0;
        String ans="";
        int vertices = vertice(s);
        int edges = edge_count(s);
        int matrix[][];
        matrix =setup_DirectedADJmatrix(s,vertices,edges);
        HashMap<Integer,Boolean>visited = new HashMap<>();
        HashMap<Integer,Integer>previsit = new HashMap<>();
        HashMap<Integer,Integer>postvisit = new HashMap<>();
        int clock=1;
        for(int i=1;i<=vertices;i++){
            visited.put(i,false);
        }
        for(int i=1;i<=vertices;i++){
            if(visited.get(i)==false){
                count+=1;
                clock=explore(i,matrix,visited,vertices,previsit,postvisit,clock);
            }
        }
        ans+=count;
        return ans;
    }
    public static void mergeSort(ArrayList<String>s){
        String one = s.get(0);
        String uno[] = one.split(" ");
        int n = Integer.parseInt(uno[0]);
        String two= s.get(1);
        String oof[] = two.split(" ");
        int a[]= new int[n];
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(oof[i]);
        }

    }
    public static String twoSum(ArrayList<String>s){
        String first_ln = s.get(0);
        String ans="";
        String insts[] = first_ln.split(" ");
        int k=Integer.parseInt(insts[0]);
        int n=Integer.parseInt(insts[1]);
        for(int i=1;i<=k;i++){
            String array = s.get(i);
            int a[] = new int[n];
            String arr[] = array.split(" ");
            for(int j=0;j<n;j++){
                a[j] = Integer.parseInt(arr[j]);
            }
            int flag=0;
            for(int x=0;x<n;x++){
                for(int y=x+1;y<n;y++){
                    if(flag==1){
                        break;
                    }
                    if(a[x]+a[y]==0){
                        flag=1;
                        ans+=x+1;
                        ans+=" ";
                        ans+=y+1;
                        ans+="\n";
                        break;
                    }
                }
                if(flag==1){
                    break;
                }
            }
            if(flag==0){
                ans+=-1;
                ans+="\n";
            }
        }
        return ans;
    }
    public static void explore_cycle(int u,int matrix[][],HashSet<Integer>unvisited, HashSet<Integer>exploring,HashSet<Integer>complete){
        int size = unvisited.size() + exploring.size()+complete.size();
        if(size!=0) {
            unvisited.remove(u);
            exploring.add(u);
            for (int v = 1; v <= size; v++) {
                if (matrix[u - 1][v - 1] == 1) {
                    if ((unvisited.contains(v) == true)) { //IF SET IS IN THE UNVISITED SET
                        explore_cycle(v, matrix, unvisited, exploring, complete);
                    } else if (exploring.contains(v) == true) {
                        exploring.clear();
                        unvisited.clear();
                        complete.clear();
                    }
                }
            }
        }
    }
    public static String acyclic(ArrayList<String>s){
        //CODE TO SETUP QUESTIONS WITH MULTIPLE GRAPHS
        ArrayList<Integer>graph_str= new ArrayList<>();
        for(int i=0;i<s.size();i++){
            String sq=s.get(i);
            if(sq.length()==0){
                graph_str.add(i+1);
            }
            if(i==s.size()-1){
                graph_str.add(i+1);
            }
        }
        String ans="";
        int number=1;
        for(int j=1;j<graph_str.size();j++){
            int end=0;
            int start = graph_str.get(j-1);
            if(j!=graph_str.size()-1) {
                end = graph_str.get(j) - 2;
            }
            else{
                end = graph_str.get(j)-1;
            }
            String insts = s.get(start);
            String ew[] = insts.split(" ");
            int vertices = Integer.parseInt(ew[0]);
            int edges = Integer.parseInt(ew[1]);
            int matrix[][] = new int[vertices+1][vertices+1];
            for(int pointer=start+1;pointer<=end;pointer++){
                String temp = s.get(pointer);
                String w[] = temp.split(" ");
                int a = Integer.parseInt(w[0]);
                int b = Integer.parseInt(w[1]);
                matrix[a-1][b-1]=1;
            }

            //ALGORITHM FOR NORMAL DFS
            HashSet<Integer>unvisited = new HashSet<>();
            HashSet<Integer>exploring = new HashSet<>();
            HashSet<Integer>complete = new HashSet<>();
            boolean cycle=false;
            for(int i=1;i<=vertices;i++){
                unvisited.add(i);
            }
            for(int i=1;i<=vertices;i++) {
                int size = unvisited.size() + exploring.size()+complete.size();
                if(size==0){
                    number=-1;
                }
                if((unvisited.contains(i))&&(size!=0)) {
                    complete = (HashSet) exploring.clone();
                    exploring.clear();
                    explore_cycle(i, matrix, unvisited, exploring, complete);
                }
            }
            ans+=number;
            ans+=" ";
            number=1;
        }
        return ans;
    }  //DONT KNOW THE MISTAKE
    public static int[] CheckthreeSum(String []val, int n){
        HashMap<Integer,Integer>pos = new HashMap<>();
        int ar[]= new int[n];
        for(int q=0;q<n;q++){
            ar[q] = Integer.parseInt(val[q]);
            if(!pos.containsKey(ar[q])) {
                pos.put(ar[q], q + 1);
            }
        }
        //System.out.println(pos);
        Arrays.sort(ar);
        int ans[]={-1,0,0};
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
                int sum=ar[i]+ar[l]+ar[r];
                if(sum==0){
                    ans= new int[]{pos.get(ar[i]), pos.get(ar[l]), pos.get(ar[r])};
                    Arrays.sort(ans);
                    return ans;
                }
                else if(sum<0){
                    l+=1;
                }
                else{
                    r-=1;
                }
            }
        }
        return ans;
    }
    public static String threeSum(ArrayList<String>s){
        String res="";
        String temp= s.get(0);
        String ins[] = temp.split(" ");
        int k=Integer.parseInt(ins[0]);
        int n=Integer.parseInt(ins[1]);
        for(int i=1;i<=k;i++){
            String temp2 = s.get(i);
            String val[] = temp2.split(" ");
            int ans[]=new int[3];
            ans=CheckthreeSum(val,n);
            if(ans[0]!=-1){
                res+=ans[0];
                res+=" ";
                res+=ans[1];
                res+=" ";
                res+=ans[2];
                res+="\n";
            }
            else{
                res+=ans[0];
                res+="\n";
            }
        }
        return res;
    }
    public static String partialSort(ArrayList<String>s){
        String ans="";
        int n=Integer.parseInt(s.get(0));
        int k=Integer.parseInt(s.get(2));
        String temp=s.get(1);
        int ar[]=new int[n];
        String val[]= temp.split(" ");
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(val[i]);
        }
        Arrays.sort(ar);
        for(int i=0;i<k;i++){
            ans+=ar[i];
            ans+=" ";
        }
        return ans;
    }
    public static String median(ArrayList<String>s){
        String ans="";
        int n=Integer.parseInt(s.get(0));
        int k=Integer.parseInt(s.get(2));
        String temp=s.get(1);
        int ar[]=new int[n];
        String val[]= temp.split(" ");
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(val[i]);
        }
        Arrays.sort(ar);
        ans+=ar[k-1];
        ans+=" ";
        return ans;
    }
    public static int preVisit(int v,HashMap<Integer,Integer>previst,int clock){
        previst.put(clock,v);
        clock+=1;
        return clock;
    }
    public static int postVisit(int v,HashMap<Integer,Integer>postvist,int clock){
        postvist.put(clock,v);
        clock+=1;
        return clock;
    }
    public static int explore(int u,int matrix[][],HashMap<Integer,Boolean>visited,int vertices,HashMap<Integer,Integer>previsit,HashMap<Integer,Integer>postvisit,int clock){
        visited.replace(u,true);
        clock=preVisit(u,previsit,clock);
        for(int j=1;j<=vertices;j++){
            if(matrix[u-1][j-1]==1){
                if(visited.get(j)==false){
                    clock=explore(j,matrix,visited,vertices,previsit,postvisit,clock);
                }
            }
        }
        clock=postVisit(u,postvisit,clock);
        return clock;
    }
    public static String topologicalSort(ArrayList<String>s){
        String ans="";
        int vertices = vertice(s);
        int edges = edge_count(s);
        int matrix[][];
        matrix =setup_DirectedADJmatrix(s,vertices,edges);
        HashMap<Integer,Boolean>visited = new HashMap<>();
        HashMap<Integer,Integer>previsit = new HashMap<>();
        HashMap<Integer,Integer>postvisit = new HashMap<>();
        int clock=1;
        for(int i=1;i<=vertices;i++){
            visited.put(i,false);
        }
        for(int i=1;i<=vertices;i++){
            if(visited.get(i)==false){
                clock=explore(i,matrix,visited,vertices,previsit,postvisit,clock);
            }
        }
        while(postvisit.size()!=0){
            if(postvisit.containsKey(clock)){
                ans+=postvisit.get(clock);
                ans+=" ";
                postvisit.remove(clock);
            }
            else{
                clock-=1;
            }
        }
        return ans;
    }
    public static String SCC(ArrayList<String>s){
        String ans="";
        int vertices = vertice(s);
        int edges = edge_count(s);
        int matrix[][];
        int transpose[][];
        matrix =setup_DirectedADJmatrix(s,vertices,edges);
        transpose=transPose(matrix,vertices);
        HashMap<Integer,Boolean>visited = new HashMap<>();
       /* print_adjMatrix(matrix,vertices);
        System.out.println("**********");
        print_adjMatrix(transpose,vertices);*/
        HashMap<Integer,Integer>previsit = new HashMap<>();
        HashMap<Integer,Integer>postvisit = new HashMap<>();

        //DFS ON TRANSPOSE
        int clock=1;
        for(int i=1;i<=vertices;i++){
            visited.put(i,false);
        }
        for(int i=1;i<=vertices;i++){
            if(visited.get(i)==false){
                clock=explore(i,transpose,visited,vertices,previsit,postvisit,clock);
            }
        }
        /*PRINTING RESULTS
        print_adjMatrix(transpose,vertices);
        System.out.println(previsit);
        System.out.println(postvisit);
        System.out.println("**********");*/

        //ORDERING VERTICES
        ArrayList<Integer>postOrdered = new ArrayList<>();
        while(postvisit.size()!=0){
            if(postvisit.containsKey(clock)){
                postOrdered.add(postvisit.get(clock));
                postvisit.remove(clock);
            }
            else{
                clock-=1;
            }
        }
        /*System.out.println(postOrdered);
        System.out.println("**********");*/

        //RESETTING
        previsit.clear();
        visited.clear();
        postvisit.clear();

        //DFS ON G WITH POSTORDERED VERTICES
        clock=1;
        int count=0;
        for(int i=0;i<postOrdered.size();i++){
            visited.put(postOrdered.get(i),false);
        }
        for(int i=0;i<postOrdered.size();i++){
            if(visited.get(postOrdered.get(i))==false){
                count+=1;
                clock=explore(postOrdered.get(i),matrix,visited,vertices,previsit,postvisit,clock);
            }
        }
        /*print_adjMatrix(matrix,vertices);
        System.out.println(previsit);
        System.out.println(postvisit);
        System.out.println("**********");*/
        ans+=count;
        return ans;
    }
    public static int[][] setup_DirectedWeighted(ArrayList<String>s,int vertices, int edge_count,HashMap<Double,Integer>weight){
        int matrix[][] = new int[vertices+1][vertices+1];
        for(int i=1;i<edge_count+1;i++){
            String temp = s.get(i);
            String tp[]= temp.split(" ");
            int a = Integer.parseInt(tp[0]);
            int b = Integer.parseInt(tp[1]);
            int w= Integer.parseInt(tp[2]);
            double edgeKey=(a*1000)+b;
            weight.put(edgeKey,w);
            matrix[a-1][b-1]=1;
        }
        return matrix;
    }
    public static int minDistance(HashMap<Integer,Integer>distance,HashSet<Integer>visited){
        int u=-1;
        for(int i=1;i<=distance.size();i++){
            if(!visited.contains(i)&&((u==-1) ||(distance.get(i) < distance.get(u)))){
                u=i;
            }
        }
        return u;
    }
    public static String Dijkstra(ArrayList<String>s){
        //SETTING UP GRAPH WITH WEIGHTS
        String ans="";
        int vertices = vertice(s);
        int edges = edge_count(s);
        int matrix[][];
        HashMap<Double,Integer>weights = new HashMap<>();
        matrix =setup_DirectedWeighted(s,vertices,edges,weights);

        //ALGO
        HashMap<Integer,Integer>distance = new HashMap<>();
        HashSet<Integer>visited= new HashSet<>();
        ArrayList<Integer>q = new ArrayList<>();
        for(int i=1;i<=vertices;i++){
            distance.put(i,Integer.MAX_VALUE);
            q.add(i);
        }
        distance.replace(1,0);
        //System.out.println(distance);
        while(visited.size()<vertices){
            int u = minDistance(distance,visited);
            visited.add(u);
            /*System.out.println("U-->"+u);
            System.out.println(visited);
            System.out.println(distance);
            System.out.println("*****************");*/
            for(int v=1;v<=vertices;v++){
                if(matrix[u-1][v-1]==1){
                    //System.out.println("EDGE(U,V)-->"+"("+u+","+v+")");
                    if(distance.get(u)==Integer.MAX_VALUE){
                        break;
                    }
                    int edgeKey=((u)*1000) +v;
                    if(distance.get(v)>(  distance.get(u)+ weights.get(edgeKey))){
                        distance.replace(v, distance.get(u)+ weights.get(edgeKey));
                    }
                }
            }
        }
        //System.out.println(distance);
        for(int i=1;i<=distance.size();i++){
            if(distance.get(i)==Integer.MAX_VALUE){
                ans+=-1;
            }
            else{
                ans+=distance.get(i);
            }
            ans+=" ";
        }
        return ans;
    }
    public static void update(int u, int v, HashMap<Integer,Double>distance, HashMap<Double,Integer>weights){
        double edgeKey=(1000*u)+v;
        double val = Math.min(distance.get(v),(distance.get(u)+weights.get(edgeKey)));
        distance.replace(v,val);
    }
    public static String BellmanFord(ArrayList<String>s){
        String ans="";
        int vertices = vertice(s);
        int edges = edge_count(s);
        int matrix[][];
        HashMap<Double,Integer>weights = new HashMap<>();
        matrix =setup_DirectedWeighted(s,vertices,edges,weights);

        HashMap<Integer,Double>distance = new HashMap<>();
        for(int i=1;i<=vertices;i++){
            distance.put(i,Double.POSITIVE_INFINITY);
        }
        distance.replace(1,0.0);
        for(int i=1;i<vertices-1;i++){
            for(int u=1;u<=vertices;u++){
                for(int v=1;v<=vertices;v++){
                    if(matrix[u-1][v-1]==1){
                        update(u,v,distance,weights);
                    }
                }
            }
        }
        for(int i=1;i<=distance.size();i++){
            if(distance.get(i)==Double.POSITIVE_INFINITY){
                ans+="x";
            }
            else{
                double dis = distance.get((i));
                int dist = (int)(dis);
                ans+=dist;
            }
            ans+=" ";
        }
        return ans;
    }
    public static void quickSort(int[]a,int low,int high){
        if(low<high){
            int point = partition(a,low,high);
            quickSort(a,low,point-1);
            quickSort(a,point+1,high);
        }
    }
    public static int partition(int[]a,int low,int high){
        int pivot = a[high];
        int i=low;
        for(int j=low;j<high;j++){
            if(a[j]<pivot){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i+=1;
            }
        }
        int temp2=a[i];
        a[i]=a[high];
        a[high]=temp2;
        return i;
    }
    public static String QuickSortFin(ArrayList<String>s){
        String ans="";
        int n=Integer.parseInt(s.get(0));
        String temp = s.get(1);
        String ins[]=temp.split(" ");
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(ins[i]);
        }
        quickSort(a,0,n-1);
        for(int i=0;i<n;i++){
            ans+=a[i];
            ans+=" ";
        }
        return ans;
    }
    public static void mergeSort(int[]a,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    public static void merge(int a[], int low, int mid, int high) {
        int temp[] = new int[high - low + 1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= high) {
            if(a[i] <= a[j]) {
                temp[k] = a[i];
                k += 1;
                i += 1;
            }
            else {
                temp[k] = a[j];
                k += 1;
                j += 1;
            }
        }

        while(j <= high) {
            temp[k] = a[j];
            k += 1;
            j += 1;
        }
        while(i <= mid) {
            temp[k] = a[i];
            k += 1;
            i += 1;
        }
        for(i = low; i <= high; i += 1) {
            a[i] = temp[i - low];
        }
    }
    public static String MergeSortFin(ArrayList<String>s){
        String ans="";
        int n=Integer.parseInt(s.get(0));
        String temp = s.get(1);
        String ins[]=temp.split(" ");
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(ins[i]);
        }
        mergeSort(a,0,n-1);
        for(int i=0;i<n;i++){
            ans+=a[i];
            ans+=" ";
        }
        return ans;
    }


    //INPUT & OUTPUT
    public static ArrayList<String> inRead(String a) throws IOException {
        String line;
        ArrayList<String> instruction = new ArrayList<String>();
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(a);
            br = new BufferedReader(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while ((line = br.readLine()) != null) {
            instruction.add(line);
        }
        br.close();
        if (fr != null) {
            fr.close();
        }
        return instruction;
    }
    public static void emitOutput(String a)throws IOException{
        PrintWriter writer = new PrintWriter("out.txt");
        writer.println(a);
        writer.close();
    }


    public static void main(String[] args) throws IOException{
        ArrayList<String>instructions = new ArrayList<>();
        instructions=inRead("testing.txt");
        String ans=MergeSortFin(instructions);
        emitOutput(ans);
    }

}
