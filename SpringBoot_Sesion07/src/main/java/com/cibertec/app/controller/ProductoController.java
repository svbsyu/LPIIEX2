package com.cibertec.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.app.entity.Producto;
import com.cibertec.app.service.CategoriaService;
import com.cibertec.app.service.ProductoService;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService Productoservice;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/producto")
    public String listProducto(Model model) {
        model.addAttribute("productos", Productoservice.getAllProducto());
        return "producto/index";
    }

    @GetMapping("/producto/new")
    public String createProductoForm(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("categoriaList", categoriaService.getAllCategoria());
        return "producto/create";
    }
    @PostMapping("/producto")
    public String saveProducto(@ModelAttribute("producto")Producto producto) {
        Productoservice.saveProducto(producto);
        return "redirect:/producto";
    }
    
	@GetMapping("/producto/edit/{id}")
	public String editProductoForm(@PathVariable Integer id, Model model) {
        Producto st = Productoservice.findProductoById(id);
		model.addAttribute("producto", st);
        model.addAttribute("categoriaList", categoriaService.getAllCategoria());
		return "producto/edit";
	}
	@PostMapping("/producto/{id}")
	public String updateProducto(@PathVariable Integer id,
			@ModelAttribute("producto")Producto producto, Model model) {
        Producto existentProducto = Productoservice.findProductoById(id);
		existentProducto.setIdProd(id);
		existentProducto.setDescripcion(producto.getDescripcion());
		existentProducto.setPrecio(producto.getPrecio());
        existentProducto.setStock(producto.getStock());
        existentProducto.setCategoria(producto.getCategoria());
        Productoservice.updateProducto(existentProducto);
		return "redirect:/producto";
	}

    @GetMapping("/producto/{id}")
    public String deleteProducto(@PathVariable Integer id) {
        Productoservice.deleteProductoById(id);
        return "redirect:/producto";
    }
}
