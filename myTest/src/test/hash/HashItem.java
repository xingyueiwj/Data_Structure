package test.hash;

/**
 * 哈希函数采用除余数法,解决哈希冲突的函数采用开放定址法中的线性探查法
 * Created by Administrator on 2017/3/13 0013.
 */
public class HashItem {
    int data;
    int info;
    HashItem(int i){
        info = i;
    }
    HashItem(int d,int i){
        data = d;
        info = i;
    }
}
