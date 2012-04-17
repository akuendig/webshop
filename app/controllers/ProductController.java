package controllers;

import java.util.ArrayList;

import model.Product;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.product.*;

public class ProductController extends Controller {
	
	public static Result index(){
		return ok(list.render(new ArrayList<Product>()));
	}
	
	public static Result like(Long id){
		return ok(id.toString());
	}

}
