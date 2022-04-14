package repository;

import entity.Todolist;

public class TodoListRepositoryImpl implements TodoListRepository{

    private Todolist[] data = new Todolist[10];

    public boolean isFull(){
        //cek data ada null
        var isFull = true;
        for (var i = 0; i < data.length;i++){
            if (data[i] == null){
                isFull = false;
            }
        }
        return isFull;
    }

    public void resizeIsFull(){
        //jika array penuh, kita resize arraynya
        if (isFull()){
            var temp = data;
            data = new Todolist[data.length * 2];
            for(var i = 0; i < temp.length ;i++){
                data[i] = temp[i];
            }
        }
    }

    @Override
    public Todolist[] getAll() {
        return data;
    }

    @Override
    public void add(Todolist todolist) {
        //resize
        resizeIsFull();
        //tambahakan data ke array null
        for (var i = 0; i < data.length; i++){
            if (data[i] == null){
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public void remove(Todolist todolist) {

    }
}
