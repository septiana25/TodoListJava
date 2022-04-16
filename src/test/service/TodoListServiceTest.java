package test.service;

import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        tesHapusTodoList();
    }

    public static void testTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        //todoListRepository.data[0] = new Todolist("Berlajar Java");
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void tesAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.addTodoList("Belajar Java");
        todoListService.addTodoList("Belajar PHP");
        todoListService.addTodoList("Belajar Golang");

        todoListService.showTodoList();
    }

    public  static void  tesHapusTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.addTodoList("Belajar Java");
        todoListService.addTodoList("Belajar PHP");
        todoListService.addTodoList("Belajar Golang");

        todoListService.showTodoList();

        todoListService.removeTodoList(1);

        todoListService.showTodoList();

        todoListService.removeTodoList(5);

        todoListService.showTodoList();

    }
}
