package com.codeclan.example.FileSystem;

import com.codeclan.example.FileSystem.models.File;
import com.codeclan.example.FileSystem.models.Folder;
import com.codeclan.example.FileSystem.models.User;
import com.codeclan.example.FileSystem.repositories.FileRepository;
import com.codeclan.example.FileSystem.repositories.FolderRepository;
import com.codeclan.example.FileSystem.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileSystemApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canAddUser() {
		User user = new User("Duncan");
		userRepository.save(user);
	}

	@Test
	public void canAddFolder() {
		User user = new User("Macbeth");
		userRepository.save(user);

		Folder folder = new Folder("Java Stuff", user);
		folderRepository.save(folder);
	}

	@Test
	public void canAddFileAndFolder() {
		User user = new User("Margaret");
		userRepository.save(user);

		Folder folder = new Folder("Ruby Stuff", user);
		folderRepository.save(folder);

		File file = new File("my_app", "rb", 100, folder);
		fileRepository.save(file);
	}

	@Test
	public void canHaveUserWithMultipleFolders() {
		User user = new User("Robert");
		userRepository.save(user);

		Folder folder1 = new Folder("JavaScript Stuff", user);
		folderRepository.save(folder1);

		Folder folder2 = new Folder("Rust Stuff", user);
		folderRepository.save(folder2);
	}

	@Test
	public void canHaveFolderWithMultipleFiles(){
		User user = new User("James");
		userRepository.save(user);

		Folder folder = new Folder("Java Work", user);
		folderRepository.save(folder);

		File file1 = new File("MyApp", "java", 100, folder);
		fileRepository.save(file1);

		File file2 = new File("SnowmanGame", "java", 100, folder);
		fileRepository.save(file2);
	}

	@Test
	public void canHaveUserWithMultipleFoldersWithMultipleFiles(){
		User user = new User("Mary");
		userRepository.save(user);

		Folder folder1 = new Folder("Java Files", user);
		folderRepository.save(folder1);

		File file1 = new File("HistoryApp", "java", 100, folder1);
		fileRepository.save(file1);

		File file2 = new File("SystemProgram", "java", 100, folder1);
		fileRepository.save(file2);

		Folder folder2 = new Folder("Python Files", user);
		folderRepository.save(folder2);

		File file3 = new File("hello", "py", 100, folder2);
		fileRepository.save(file3);

		File file4 = new File("data_analysis", "py", 100, folder2);
		fileRepository.save(file4);


	}



}
