package services;

import entities.User;
import models.bindingModels.LoginModel;
import org.modelmapper.ModelMapper;
import repositories.UserRepository;
import repositories.UserRepositoryImpl;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl() {
        this.userRepository = UserRepositoryImpl.getInstance();
        this.modelMapper = new ModelMapper();
    }


    @Override
    public void createUser(LoginModel loginModel) {
        User user = this.modelMapper.map(loginModel, User.class);
        user.setId(UUID.randomUUID().toString());

        this.userRepository.createUser(user);
    }

    @Override
    public LoginModel findByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);

        if (user == null) {
            return null;
        }

        return this.modelMapper.map(user, LoginModel.class);
    }
}