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
    public boolean remove(Integer number) {
        //cek number > dari panjang array or number array null = false
        if((number -1) >= data.length){
            return false;
        }else if(data[number-1] == null){

            return false;
        }else{
            for(var i = (number-1); i < data.length; i++){
                if(data.length - 1 == i){
                    data[i] = null;
                }else{
                    data[i] = data[i+1];
                }
            }
            return true;
        }
    }
}
