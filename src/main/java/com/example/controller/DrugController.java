package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Drugs;
import com.example.service.DrugService;
import com.mysql.cj.xdevapi.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@Controller
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class DrugController {

    @Autowired
    DrugService drugService;

    @GetMapping("/all")
    public List<Drugs> getAllDrugs() {
        return drugService.findAllDrugs(); // 调用Service层的list方法获取所有药品
    }

    @GetMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDrugById(@PathVariable int id) {
        Drugs drug = drugService.findDrugById(id); // 调用Service层查询药品
        if (drug != null) {
            return ResponseEntity.ok(drug); // 如果药品存在，返回药品信息和200 OK状态码
        } else {
            return ResponseEntity.notFound().build(); // 如果药品不存在，返回404 Not Found状态码
        }
    }

    @PostMapping
    public ResponseEntity<?> createDrug(@RequestBody Drugs drug) {
        drugService.addDrug(drug); // 调用Service层的save方法保存新的药品
        return ResponseEntity.ok().build(); // 返回成功响应,可以省略
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDrug(@PathVariable("id") int id, @RequestBody Drugs drug) {
        drug.setId(id); // 设置要更新的药品ID
        drugService.updateDrug(drug); // 调用Service层的updateById方法更新药品
        return ResponseEntity.ok().build(); // 返回成功响应,可以省略
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDrug(@PathVariable("id") int id) {
        drugService.deleteDrug(id); // 调用Service层的removeById方法删除药品
        return ResponseEntity.ok().build(); // 返回成功响应,可以省略
    }

    //异常处理
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        // 异常处理逻辑，例如记录日志、返回错误信息等
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("药品不存在");
    }


//    @Autowired
//    private DrugService drugService;
//
//
//    @GetMapping("/drugs")
//    public ModelAndView findAllDrugs(){
//        System.out.println("drugs----");
//        List<Drugs> drugs =DrugService.findAllDrugs();
//
//        ModelAndView mv=new ModelAndView();
//        mv.addObject("drugs",drugs);
//        mv.setViewName("drugs");
//        return mv;
//    }
//
//    @GetMapping("/{id}")
//    public ModelAndView findUserById(@PathVariable("id") int id){
//        Drugs drug=drugService.findDrugById(id);
//        ModelAndView mv=new ModelAndView();
//        mv.addObject("drug",drug);
//        mv.setViewName("drug");
//        return mv;
//
//    }
//
//    @PostMapping("/addDrug")
//    public ModelAndView addStudent(Drugs durg){
//        drugService.addDrug(durg);
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("redirect:/books");//添加成功后，跳转到查找所有学生的控制器
//        return mv;
//    }
////
////    @GetMapping("/addBook")
////    public String addStudent(){
////        return "addBook";
////    }
////
////    @GetMapping("/deleteBook/{id}")
////    public ModelAndView deleteStudent(@PathVariable("id") int id){
////        bookService.deleteBook(id);
////        ModelAndView mv=new ModelAndView();
////        mv.setViewName("redirect:/books");//删除成功后，跳转到查找所有学生的控制器
////        return mv;
////    }
////
////    @GetMapping("/updateBook/{id}")
////    public ModelAndView toUpdateStudent(@PathVariable("id") int id){
////        Book book=bookService.findBookById(id);
////        ModelAndView mv=new ModelAndView();
////        mv.addObject("book",book);
////        mv.setViewName("updateBook");
////        return mv;
////    }
////
////    @PostMapping("/updateBook")
////    public ModelAndView UpdateStudent(Book book){
////
////        bookService.updateBook(book);
////        ModelAndView mv=new ModelAndView();
////        mv.setViewName("redirect:/books");//修改成功后，跳转到查找所有学生的控制器
////        return mv;
////    }
////
////    @GetMapping("/booksPage")
////    public ModelAndView booksPage(@RequestParam(value="start",defaultValue = "1")int start,
////                                  @RequestParam(value="size",defaultValue = "3") int size){ //默认查询第1页，每页显示3条
////        IPage<Book> page=bookService.getPage(start,size); //表示起始页为start,每页显示size条记录，根据id升序排序进行分页
////        ModelAndView mv=new ModelAndView();
////        mv.addObject("page",page);
////        mv.setViewName("booksPage");
////        return mv;
////    }
////
////    @GetMapping("/searchBooks")
////    public ModelAndView searchBooks(Book book){
////        List<Book> books=bookService.searchBooks(book);
////        ModelAndView mv=new ModelAndView();
////        mv.addObject("books",books);
////        mv.setViewName("books");
////        return mv;
////    }
////
////    @Autowired
////    private IBookService iBookService;
////    @GetMapping("/books2")
////    public ModelAndView findAllBooks2(){
////        List<Book> books=iBookService.list();
////        ModelAndView mv=new ModelAndView();
////        mv.addObject("books",books);
////        mv.setViewName("books");
////        return mv;
////    }
////
////    @GetMapping("/books2/{id}")
////    public ModelAndView findBooksById2(@PathVariable int id){
////        Book book=iBookService.getById(id);
////        ModelAndView mv=new ModelAndView();
////        mv.addObject("book",book);
////        mv.setViewName("book");
////        return mv;
////    }
////
//
}
