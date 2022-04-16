package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        Todolist[] data = todoListRepository.getAll();
        System.out.println("TODO LIST");
        //looping data array
        for(var i = 0; i<data.length;i++){
            var todolist = data[i];
            //beri increment no urut + 1
            var no = i +1;
            if (todolist != null){
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("Success Menambah " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        if (todoListRepository.remove(number)){
            System.out.println("Berhasil Hapus todo ke-" + number);
        }else{
            System.out.println("Gagal Hapus todo ke-"+ number);
        }
    }
}
