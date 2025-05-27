package br.gov.sp.fatec.itu.music.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.itu.music.entities.Music;
import br.gov.sp.fatec.itu.music.services.MusicService;

@RestController //criando um controller do tipo RestFul, transforma objetos java em JSON
@RequestMapping("music") 
/*aqui é a referência ao caminho da URL que usamos, isso está dizendo que esse controlador
 * irá receber todas as chamadas que usarem  localhost:8080/music, é nesse /music que se refere
*/
public class MusicController {
    
    @Autowired //injetando o serviço no controlador, ou seja, quem o controller chama
    private MusicService service;

    @GetMapping 
    /*está mapeando as requisições do tipo GET pra essa função
      ou seja, toda vez que a requisição da API for do tipo GET, irá chamar essa função getall()
    */
    
    public ResponseEntity<List<Music>> getAll(){
        /*ResponseEntity é uma resposta completa HTTP ela contém STATUS CODE, HEADERS, CORPO DE RESPOSTA
        Ela é um controle total da resposta HTTP, no nosso caso:
        
        Status Code -> Vai ser 200, pois é a de OK
        HEADERS -> Já tem alguns padrões, mas geralmente tamanho do content, titulo etc
        CORPO (BODY) da RESPONSE -> Vai ser nossa lista de Music
        */
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping //mapeando como requsição do tipo POST
    public ResponseEntity<Music> save(@RequestBody Music music){
        //A resposta será um corpo do tipo MUSIC
        //ao chamar o método save do service passa como parametro um objeto Music que veio do CORPO DA REQUISIÇÃO (ou seja, do FRONT-END)
        //veio um arquivo JSON e o spring tem que transformar em um objeto Music
        
        return ResponseEntity.created(null).body(service.save(music));
        //O método retorna uma resposta do tipo "CREATED" e o corpo dessa resposta vai conter o retorno do serviço
        //ou seja, no responseEntity vai ter: 
        //STATUS CODE: 201 (CREATED)
        //HEADER DA RESPOSTA
        //CORPO DA RESPOSTA -> Esse sendo o retorno do método save do serviço  no caso return repository.save(music);
        //esse body seria um modelo JSON com os dados 

    }
    

}
