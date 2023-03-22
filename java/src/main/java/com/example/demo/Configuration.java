package com.example.demo;

import com.example.demo.commands.CommandAddRating;
import com.example.demo.commands.CommandAddReview;
import com.example.demo.commands.CommandDescribeRestaurant;
import com.example.demo.commands.CommandGetReviews;
import com.example.demo.commands.CommandGetReviewsFilterOrder;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandListRestaurant;
import com.example.demo.commands.CommandRegisterRestaurant;
import com.example.demo.commands.CommandRegisterUser;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewRepository;
import com.example.demo.repositories.IUserRespository;
import com.example.demo.repositories.RestaurantRepository;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.GreetingService;
import com.example.demo.services.RestaurantService;
import com.example.demo.services.ReviewService;
import com.example.demo.services.UserService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
            private final IRestaurantRepository restaurantRepository = new RestaurantRepository();
            private final IReviewRepository reviewRepository = new ReviewRepository();
            private final IUserRespository userRespository = new UserRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            private final RestaurantService restaurantService = new RestaurantService(restaurantRepository);
            private final ReviewService reviewService = new ReviewService(reviewRepository, userRespository, restaurantRepository);
            private final UserService userService = new UserService(userRespository);

            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);

            private final CommandRegisterRestaurant  registerRestaurantCommand = new CommandRegisterRestaurant(restaurantService);
            private final CommandRegisterUser  registerUserCommand = new CommandRegisterUser(userService);
            private final CommandAddRating  addRatingCommand = new CommandAddRating(reviewService);
            private final CommandAddReview  addReviewCommand = new CommandAddReview(reviewService);
            private final CommandGetReviews  getReviewsCommand = new CommandGetReviews(reviewService);
            private final CommandGetReviewsFilterOrder  getReviewsFilterOrder = new CommandGetReviewsFilterOrder(reviewService);
            private final CommandDescribeRestaurant  describeRestaurantCommand = new CommandDescribeRestaurant(restaurantService);
            private final CommandListRestaurant listRestaurantCommand = new CommandListRestaurant(restaurantService);

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);

                commandRegistry.registerCommand(CommandKeyword.REGISTER_RESTAURANT_COMMAND.getName(),registerRestaurantCommand);
                commandRegistry.registerCommand(CommandKeyword.REGISTER_USER_COMMAND.getName(),registerUserCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_RATING_COMMAND.getName(), addRatingCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_REVIEW_COMMAND.getName(),addReviewCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS_COMMAND.getName(),getReviewsCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS_FILTER_ORDER_COMMAND.getName(),getReviewsFilterOrder);
                commandRegistry.registerCommand(CommandKeyword.DESCRIBE_RESTAURANT_COMMAND.getName(),describeRestaurantCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_RESTAURANTS_COMMAND.getName(),listRestaurantCommand);
            
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
