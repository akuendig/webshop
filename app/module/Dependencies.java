package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;

import controllers.UserStore;
import data.IBrandRepository;
import data.ICategoryProductRepository;
import data.ICategoryRepository;
import data.ICommentRepository;
import data.ILikeRepository;
import data.IOriginRepository;
import data.IProductRepository;
import data.IRecipeProductRepository;
import data.IRecipeRepository;
import data.IShoppingCartRepository;
import data.IShoppingcartProductRepository;
import data.IUserRepository;
import data.filesystem.BrandRepository;
import data.filesystem.CategoryProductRepository;
import data.filesystem.CategoryRepository;
import data.filesystem.CommentRepository;
import data.filesystem.LikeRepository;
import data.filesystem.OriginRepository;
import data.filesystem.ProductRepository;
import data.filesystem.RecipeProductRepository;
import data.filesystem.RecipeRepository;
import data.filesystem.ShoppingcartRepository;
import data.filesystem.ShoppingcartProductRepository;
import data.filesystem.UserRepository;
import data.filesystem.TableLocator;

public class Dependencies implements Module {

    public static final String USERNAME = "introdb";
    public static final String PASSWORD = "1234";
    public static final String HOSTNAME = "localhost";
    public static final int PORT = 3306;
    public static final String DATABASE = "introdb2012";

    public void configure(Binder binder) {
        binder.bind(UserStore.class);
        binder.bind(TableLocator.class);
        
        binder.bind(IShoppingcartProductRepository.class).to(ShoppingcartProductRepository.class).asEagerSingleton();
        binder.bind(IRecipeProductRepository.class).to(RecipeProductRepository.class).asEagerSingleton();
        binder.bind(ICategoryProductRepository.class).to(CategoryProductRepository.class).asEagerSingleton();
        
        binder.bind(IBrandRepository.class).to(BrandRepository.class).asEagerSingleton();
        binder.bind(ICategoryRepository.class).to(CategoryRepository.class).asEagerSingleton();
        binder.bind(ICommentRepository.class).to(CommentRepository.class).asEagerSingleton();
        binder.bind(ILikeRepository.class).to(LikeRepository.class).asEagerSingleton();
        binder.bind(IOriginRepository.class).to(OriginRepository.class).asEagerSingleton();
        binder.bind(IProductRepository.class).to(ProductRepository.class).asEagerSingleton();
        binder.bind(IRecipeRepository.class).to(RecipeRepository.class).asEagerSingleton();
        binder.bind(IShoppingCartRepository.class).to(ShoppingcartRepository.class).asEagerSingleton();
        binder.bind(IUserRepository.class).to(UserRepository.class).asEagerSingleton();
    }

    @Provides
    Connection provideConnection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection =
                DriverManager.getConnection(
                    "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE,
                    USERNAME,
                    PASSWORD);

        } catch (final
            SQLException | InstantiationException | IllegalAccessException
            | ClassNotFoundException e) {

            /**
             * Make sure that we really see this error.
             */
            System.err
                .println("Could not connect to MYSQL. Is the server running?");

            e.printStackTrace();

        }

        return connection;
    }
}
