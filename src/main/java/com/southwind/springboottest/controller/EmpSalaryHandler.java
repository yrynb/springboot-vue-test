package com.southwind.springboottest.controller;

import com.southwind.springboottest.IdGenarater;
import com.southwind.springboottest.entity.Empsalary;
import com.southwind.springboottest.repository.EmpSalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empsalary")
public class EmpSalaryHandler {
    @Autowired
    private EmpSalaryRepository EmpSalaryRepository;
    @Autowired
    private IdGenarater idGenarater;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Empsalary> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return EmpSalaryRepository.findAll(request);
    }

    @PostMapping("/save")
    public String save(@RequestBody Empsalary empSalary){
        empSalary.setEID((int) idGenarater.nextId());
        Empsalary result = EmpSalaryRepository.save(empSalary);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

//     @GetMapping("/save/{name}/{author}")
//     public String save(@PathVariable("name") String name,@PathVariable("author") String author){
//        Book book = new Book();
//        book.setId((int) idGenarater.nextId());
//        book.setName(name);
//        book.setAuthor(author);
//         System.out.println(book);
//        Book result = bookRepository.save(book);
//     if(result != null){
//          return "success";
//     }else{
//         return "error";
//     }
//}

    @GetMapping("/findById/{id}")
    public Empsalary findById(@PathVariable("id") Integer id){
        return EmpSalaryRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Empsalary empSalary){
        Empsalary result = EmpSalaryRepository.save(empSalary);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

//    @DeleteMapping("/deleteById/{eid}")
    @GetMapping("/deleteById/{eid}")
    public void deleteById(@PathVariable("eid") Integer eid){
        EmpSalaryRepository.deleteById(eid);
    }
}
