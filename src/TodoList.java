public class TodoList {
    public static String[] data = new String[4];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        testViewRemoveTodoList();
    }
    /**
     * Menampilkan todo list
     */

    public static String input(String info){
        System.out.println(info + ":");
        var data = scanner.nextLine();
        return  data;
    }

    public static void testInput(){
        var name = input("nama");
        System.out.println("Hai" + name);
    }
    public static void showTodoList(){
        System.out.println("TODO LIST");
        //looping data array
        for(var i = 0; i<data.length;i++){
            //beri increment no urut + 1
            var no = i +1;
            if (data[i] != null){
                System.out.println(no + ". " + data[i]);
            }
        }


    }

    public static void testShowTodoList(){
        data[0] = "Belajar";
        showTodoList();
    }

    /**
     * Menambah todo List
     */
    public static void addTodoList(String todo){
        //cek data null
        var isFull = true;
        for(var i = 0; i < data.length; i++){
            if(data[i] == null){
                isFull = false;
            }
        }
        //resize data x 2
        if (isFull){
            var temp = data;
            data = new String[data.length * 2];
            for (var i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }
        //isi ke data null
        for (var i = 0; i < data.length; i++){
            if (data[i] == null){
                data[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList(){
        //addTodoList("Data Ditambah Ke-");
        for (var i = 0; i < 4; i++){
            addTodoList("Data Ditambah Ke-"+i);
        }
        showTodoList();
        System.out.println(data.length);

    }

    /**
     * Hapus todo List
     */
    public static boolean  removeTodoList(Integer number){
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
        //5 - = 4 | 4
        //jika data benar lakukan tukar posisi array


    }

    public static void testRemoveTodoList(){
        for (var i = 0; i < 4; i++){
            addTodoList("Data Ditambah Ke-"+i);
        }
        showTodoList();
        System.out.println(data.length);

        var result = removeTodoList(1);
        System.out.println(result);
        showTodoList();
    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();
            System.out.println("+ MENU +");
            System.out.println("1. Tambah Todo List");
            System.out.println("2. Hapus Todo List");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan Tidak Ada");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        viewShowTodoList();
    }

    /**
     * Menampilkan view tambah todo list
     */
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODO LIST");
        var input = input("(x) Jika Batal");
        if (input.equals("x")){
            //batal input
        }else{
            addTodoList(input);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddTodoList();
        showTodoList();
    }
    /**
     * Menampilkan view hapus todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODO LIST");
        var input = input("Nomor Urut Todo List, (x) Jika Batal");
        if (input.equals("x")){
            //Batal
        }else{
            //check apakah type data int
            boolean checkInt = input.matches("-?\\\\d+");
            if (checkInt){
                boolean success = removeTodoList(Integer.valueOf(input));
                if(!success){
                    System.out.println("Gagal Menghapus No ke-"+input);
                }
            }else {
                System.out.println("Pilihan Salah");
            }

        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
