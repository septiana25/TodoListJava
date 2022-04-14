package test.service;

import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        tesAddTodoList();
    }

    public static void testTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        //todoListRepository.data[0] = new Todolist("Berlajar Java");
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void tesAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        todoListRepository.add(new Todolist("Belajar Java"));
        todoListRepository.add(new Todolist("Belajar PHP"));


        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.showTodoList();
    }
}
