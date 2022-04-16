package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class ViewTest {
    public static void main(String[] args) {
        viewTodoList();
    }

    public static void viewTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java");

        TodoListView todoListView = new TodoListView(todoListService);
        todoListView.viewShowTodoList();

    }

}
