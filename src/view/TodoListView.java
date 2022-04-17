package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void viewShowTodoList(){
        while (true){

            todoListService.showTodoList();

            System.out.println("+ MENU +");
            System.out.println("1. Tambah Todo List");
            System.out.println("2. Hapus Todo List");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");
            if (input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("x")){
                System.out.println("Goodbye :(");
                break;
            }else{
                System.out.println("Pilihan Tidak Ada");
            }
        }
    }

    private void viewAddTodoList(){
        System.out.println("MENAMBAH TODO LIST");
        var input = InputUtil.input("(x) Jika Batal");
        if (input.equals("x")){
            //batal input
        }else{
            todoListService.addTodoList(input);
        }

    }

    private void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODO LIST");
        var input = InputUtil.input("Nomor Urut Todo List, (x) Jika Batal");
        if (input.equals("x")){
            //Batal
        }else{
            //check apakah type data int
            try {
                todoListService.removeTodoList(Integer.valueOf(input));
            }catch (Exception e){
                System.out.println("error " +e.getMessage());
            }

        }
    }
}
