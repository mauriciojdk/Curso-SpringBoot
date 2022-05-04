package com.mauriciojdk.SpringExample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*Para criar uma rota necessario fazer a inclusão do RestController ou do Controller,
depois um mapeamento da minha rota -O meu endpoint principal*/
@RestController
@RequestMapping("/")
public class HelloWorld {

    // Aqui dentro consigo lidar com meu endpoint principal ou posso trabalhar com subpath
    @GetMapping
    public String sayHello(){
        return "Hello from SpringBoot by Mauriciojdk";
    }

    // SUBPATH utlizando Query String
    /*@GetMapping("/subpath")
    public String subPath(@RequestParam("name") String name){
        return "This is one subPath of endpoint /" + name;
    }*/

    //Avaliando se é requerido
    @GetMapping("/subpath")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public String subPath(@RequestParam(value = "name", required = false) String name) {
        return "This is one subPath of endpoint /" + name;
    }

    // Parâmetros dinâmicos
    @GetMapping("/{dynamic}")
    public String dynamicSubPath(@PathVariable("dynamic") String name){
        return "Hello " + name + " this is my route dynamic...";
    }

    @PostMapping("/post")
    public String sayHelloPost(@RequestBody Map<String, Object> payload){
        return payload.get("name").toString();
    }
}
