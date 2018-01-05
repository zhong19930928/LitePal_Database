package com.zhong.litepal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button createdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createdatabase = (Button) findViewById(R.id.createdatabase);
        createdatabase.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createdatabase:
                LitePal.getDatabase();
                break;
            case R.id.button1:
                addData();
                break;
            case R.id.button2:
                deleteData();
                break;
            case R.id.button3:
                updateData();
                break;
            case R.id.button4:
                selectData();
                break;



        }

    }

    /**
     * @description 往数据库添加数据
     */
    private void addData() {
        Book book = new Book();
        book.setAuthor("张三");
        book.setId(1);
        book.setName("草本纲目");
        book.setPrice(90.00);
        book.setPages(890);
        book.save();

        Book book2 = new Book();
        book2.setAuthor("李时珍");
        book2.setId(2);
        book2.setName("上下五千年");
        book2.setPrice(190.00);
        book2.setPages(5860);
        book2.save();
    }

    /**
     * @description 删除数据库数据
     */
    private void deleteData() {
        DataSupport.deleteAll(Book.class,"price > ?","100");
//        DataSupport.deleteAll(Book.class); //删除表中全部
    }

    /**
     * @description 修改数据库数据
     */
    private void updateData() {
        Book book = new Book();
        book.setAuthor("张三");
        book.setId(1);
        book.setName("草本纲目");
        book.setPrice(90.00);
        book.setPages(890);
        book.save();
        book.setPrice(0.99);
        book.save();
    }

    /**
     * @description 查询数据库数据
     */
    private void selectData() {
        List<Book> booklist = DataSupport.findAll(Book.class);
        for(Book book:booklist){
            Log.i("zhong",book.getName());
        }

//        List<Book> booklist2 = DataSupport.select("name","张三").find(Book.class);
//        List<Book> booklist3 = DataSupport.where("pages > ?","600").find(Book.class);
//        //查询book中的全部数据按照price降序，asc则表示升序排列
//        List<Book> booklist4 = DataSupport.order("price desc").find(Book.class);
//        //查询表中的前3条数据
//        List<Book> booklist5 = DataSupport.limit(3).find(Book.class);
//        //查询表中的2,3,4条数据
//        List<Book> booklist6 = DataSupport.limit(3).offset(1).find(Book.class);
//        //查询Book表中第11~20条满足页数大于400这个条件的name,author,pages这三列数据，并且按照页数升序排列；
//        List<Book> booklist7 = DataSupport.select("name","张三","pages")
//                .where("pages > ?","400")
//                .order("pages")
//                .limit(10)
//                .offset(10)
//                .find(Book.class);
    }
}
