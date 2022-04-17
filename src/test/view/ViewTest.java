package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class ViewTest {
    public static void main(String[] args) {
        viewRemoveTodoList();
    }

    public static void viewTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java");

        TodoListView todoListView = new TodoListView(todoListService);
        todoListView.viewShowTodoList();

    }

    public static void viewAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        //todoListView.viewAddTodoList();
        todoListService.showTodoList();

        //todoListView.viewAddTodoList();
        //todoListService.showTodoList();

    }

    public static void viewRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar Java");
        todoListService.addTodoList("Belajar PHP");
        todoListService.addTodoList("Belajar Golang");

        todoListService.showTodoList();
        //todoListView.viewRemoveTodoList();
        //todoListService.showTodoList();
        //todoListView.viewRemoveTodoList();
        //todoListService.showTodoList();

    }

}
