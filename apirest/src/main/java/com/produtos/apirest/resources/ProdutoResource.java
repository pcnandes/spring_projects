package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//indica q vai receber as requisicoes
@RestController
@RequestMapping(value="/api")
@Api(value="API rest produtos")
// permite que qqr endereço acesse o endpoint
@CrossOrigin(origins = "*")
public class ProdutoResource {
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produto")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna um produto")
	public Produto carregarProduto(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Salva produtos")
	public Produto salvar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto/{id}")
	@ApiOperation(value="Deleta produtos")
	public void delete(@PathVariable(value="id") long id) {
		produtoRepository.deleteById(id);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza produtos")
	public Produto update(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
