class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res=new LinkedList<>();
        // if(num==0){
        //     res.add("0:00");
        //     return res;
        // }
        List<Time>[][] arr=new List[num+1][11];
        
        for(int i=0; i<arr[0].length; i++){
            arr[0][i]=new LinkedList<Time>();
            arr[0][i].add(new Time(0, 0));
        }  
        for(int n=1; n<arr.length; n++){
            for(int i=1; i<arr[0].length; i++){
                int h=0;
                int m=0;
                if(i>=1&&i<=4)          h=1<<(i-1);
                else if(i>=5&&i<=10)     m=1<<(i-5);
                arr[n][i]=new LinkedList<Time>();
                if(arr[n-1][i-1]!=null){
                    for(Time t: arr[n-1][i-1]){
                        if((t.h+h<=11)&&(t.m+m<=59))    arr[n][i].add(new Time(t.h+h, t.m+m));
                    }
                }
                if(arr[n][i-1]!=null){
                    for(Time t: arr[n][i-1]){
                        arr[n][i].add(new Time(t.h, t.m));
                    }
                }
                //System.out.println("n:"+n+",i:"+i+"arr[n][i]"+arr[n][i]);

            }
        }
        //System.out.println(arr[arr.length-1][arr[0].length-1]);
        // for(int i=arr[0].length-1; i<arr[0].length; i++){
        for(Time t: arr[arr.length-1][arr[0].length-1]){
            if(t.m>9){
                res.add(t.h+":"+t.m);
            }else{
                res.add(t.h+":0"+t.m);
            }
        }
        // }
        Collections.sort(res, new Comparator<String>(){
            public int compare(String t1, String t2){
                String[] a1=t1.split(":");
                String[] a2=t2.split(":");
                int[] n1=new int[2];
                n1[0]=Integer.parseInt(a1[0]);
                n1[1]=Integer.parseInt(a1[1]);
                int[] n2=new int[2];
                n2[0]=Integer.parseInt(a2[0]);
                n2[1]=Integer.parseInt(a2[1]);
                if(n1[0]!=n2[0]){
                    return n1[0]-n2[0];
                }else{
                    return n1[1]-n2[1];
                }
            }
        });
        return res;
    }
    
}
class Time{
    int h;
    int m;
    Time(int h, int m){
        if((h<=11)&&(m<=59)){
            this.h=h;
            this.m=m;
        }
    }
    @Override
    public String toString(){
        return h+":"+m;
    }
    
}