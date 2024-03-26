package com.possistemaecommerc.controllers.configuration;

import com.possistemaecommerc.controllers.configuration.domain.Categoria;
import com.possistemaecommerc.infrastructure.repositories.ICategoriaRepository;
import com.possistemaecommerc.infrastructure.repositories.ICategoriasCache;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoadDataConfig implements ApplicationRunner {

    @Autowired
    private ICategoriaRepository categoriaRepository;
    @Autowired
    private ICategoriasCache categoriasCache;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Categoria> categorias = new ArrayList<Categoria>();
        categorias.add(new Categoria(1, "Informática", "Produtos de infomática", null));
        categorias.add(new Categoria(2, "Eletrônicos", "Produtos de infomática", null));
        categorias.add(new Categoria(3, "Celulares", "Celulares em geral", null));
        categorias.add(new Categoria(4, "Games", "Jogos e Consoles", null));
        categorias.add(new Categoria(5, "Livraria", "Livraria e papelaria em geral", null));
        categorias.add(new Categoria(6, "Outros", "Produtos diversos", null));
        categoriaRepository.saveAll(categorias);

        ModelMapper modelMapper = new ModelMapper();
        List<Categoria> categoria = modelMapper.map
                (categorias, new TypeToken<List<Categoria>>() {
                }.getType());
        categoriasCache.saveAll(categoria);
    }
}
