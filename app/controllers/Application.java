package controllers;

import com.google.inject.Guice;
import com.typesafe.plugin.inject.GuicePlugin;
import com.typesafe.plugin.inject.InjectPlugin;

import model.Brand;
import model.Category;
import model.CategoryContainsProduct;
import model.Origin;
import model.Product;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import data.IBrandRepository;
import data.ICategoryProductRepository;
import data.ICategoryRepository;
import data.IOriginRepository;
import data.IProductRepository;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render());
	}

	public static Result build() {
		InjectPlugin ioc = play.Play.application().plugin(InjectPlugin.class);
		
		ICategoryRepository c = ioc.getInstance(ICategoryRepository.class);
		c.create(new Category("Suessgetraenke"));
		c.create(new Category("Fleisch"));
		c.create(new Category("Alkohol"));
		c.create(new Category("Gemuese"));
		c.create(new Category("Teigwaren"));

		IOriginRepository o = ioc.getInstance(IOriginRepository.class);
		o.create(new Origin("Schweiz"));
		o.create(new Origin("Italien"));
		o.create(new Origin("Frankreich"));
		o.create(new Origin("Deutschland"));

		IBrandRepository b = ioc.getInstance(IBrandRepository.class);
		b.create(new Brand("Coca Cola"));
		b.create(new Brand("Bell"));
		b.create(new Brand("Barilla"));
		b.create(new Brand("SwissBio"));

		IProductRepository p = ioc.getInstance(IProductRepository.class);
		p.create(new Product("Coke Zero", 2000, 220, 1, 1));
		p.create(new Product("Schweins-Nierstueck", 200, 870, 2, 1));
		p.create(new Product("Krombacher-Bier", 500, 100, 1, 4));
		p.create(new Product("Spaghetti", 500, 300, 3, 2));
		p.create(new Product("Broccoli", 500, 150, 4, 1));
		p.create(new Product("Merlot", 750, 1000, 1, 3));

		ICategoryProductRepository cp = ioc.getInstance(ICategoryProductRepository.class);
	    cp.create(new CategoryContainsProduct(1,1));
	    cp.create(new CategoryContainsProduct(2,2));
	    cp.create(new CategoryContainsProduct(3,3));
	    cp.create(new CategoryContainsProduct(4,5));
	    cp.create(new CategoryContainsProduct(5,4));
	    cp.create(new CategoryContainsProduct(6,3));

		return redirect(routes.Application.index());
	}

}