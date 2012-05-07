package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;

import controllers.UserStore;
import data.IBrandRepository;
import data.ICategoryRepository;
import data.ICommentRepository;
import data.ILikeRepository;
import data.IOriginRepository;
import data.IProductRepository;
import data.IRecipeRepository;
import data.IShoppingCartRepository;
import data.IUserRepository;
import data.database.BrandRepository;
import data.database.CategoryRepository;
import data.database.CommentRepository;
import data.database.LikeRepository;
import data.database.OriginRepository;
import data.database.ProductRepository;
import data.database.RecipeRepository;
import data.database.ShoppingCartRepository;
import data.database.UserRepository;
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
        
        binder.bind(IBrandRepository.class).to(data.filesystem.BrandRepository.class);
        binder.bind(ICategoryRepository.class).to(CategoryRepository.class);
        binder.bind(ICommentRepository.class).to(CommentRepository.class);
        binder.bind(ILikeRepository.class).to(LikeRepository.class);
        binder.bind(IOriginRepository.class).to(OriginRepository.class);
        binder.bind(IProductRepository.class).to(ProductRepository.class);
        binder.bind(IRecipeRepository.class).to(RecipeRepository.class);
        binder.bind(IShoppingCartRepository.class).to(ShoppingCartRepository.class);
        binder.bind(IUserRepository.class).to(UserRepository.class);
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
