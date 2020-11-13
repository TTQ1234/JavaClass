package com.ttq.UserService;

import java.util.Scanner;

public interface UserService {
	void createUser(User user);

	User login(String name, String password);

	void showAll();

	void selectShow(User user);

	void editBalance(Scanner scanner, User user);
}
