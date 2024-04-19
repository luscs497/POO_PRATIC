import java.util.Scanner;

public class Elevator {
    private int andarAtual=0, andares, capacidade, pessoasP=0;

    public int getAndarAtual() {
        return this.andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getAndares() {
        return this.andares;
    }

    public void setAndares(int andares) {
        this.andares = andares;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getPessoasP() {
        return this.pessoasP;
    }

    public void setPessoasP(int pessoasP) {
        this.pessoasP = pessoasP;
    }

    
    public void Entrar(){
        setPessoasP(getPessoasP() + 1);
    }

    public void Sair(){
        setPessoasP(getPessoasP() - 1);
    }

    public void Subir(){
        setAndarAtual(getAndarAtual() + 1);
    }

    public void Descer(){
        setAndarAtual(getAndarAtual() - 1);
    }

    public void menu(){
        Elevator t1 = new Elevator();
        Scanner reader = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("ELEVADOR");
        System.out.println("----------------");
        System.out.println("Para prosseguir, insira: ");
        System.out.print("A capacidade máxima: ");
        t1.setCapacidade(reader.nextInt());
        System.out.print("A quantidade de andares do prédio: ");
        t1.setAndares(reader.nextInt());
        int cod;
        do{
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("O elevador se encontra no andar "+t1.getAndarAtual()+" e há "+t1.getPessoasP()+" pessoa(s)!");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Você deseja: ");
            System.out.println("[1] -- Entrar");
            System.out.println("[2] -- Sair");
            System.out.println("[3] -- Subir");
            System.out.println("[4] -- Descer");
            cod=reader.nextInt();
            switch(cod){
                case 1:
                    if(t1.getPessoasP() == t1.getCapacidade()){
                        System.out.println("Não é possível acrescentar mais pessoas ao elevador! Ele atingiu sua capacidade máxima. ");
                    }else{
                        System.out.println("Pessoa adicionada com sucesso! ");
                        t1.Entrar();
                    }
                    break;
                case 2:
                    if(t1.getPessoasP() == 0){
                        System.out.println("Não é possível remover alguém do elevador! Não há ninguém nele. ");
                    }else{
                        System.out.println("Pessoa removida com sucesso! ");
                        t1.Sair();
                    }
                    break;
                case 3:
                    if(t1.getAndarAtual() == t1.getAndares()){
                        System.out.println("Não é possível subir um andar, ele já está no último!");
                    }else{
                        t1.Subir();
                    }
                    break;
                case 4:
                    if(t1.getAndarAtual() == 0){
                        System.out.println("Não é possível descer um andar, ele está no térreo.");
                    }else{
                        t1.Descer();
                    }
                    break;
                case 99:
                    break;
            }
        }while(cod!=99);
        reader.close();
    }
}
