import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.Period;

public class Player {
    String nome, nacionalidade;
    LocalDate dataNascimento;
    int posicao;
    float altura, peso;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void mostrar(){
        if(getNome() == null){
            System.out.println("Não há jogadores cadastrados.");
        }else{
            System.out.print("O jogador chamado "+getNome()+", é "+getNacionalidade()+" e da posição ");
            switch(getPosicao()){
                case 1:
                    System.out.print("de defesa, ");
                    break;
                case 2:
                    System.out.print("de meio campo, ");
                    break;
                case 3:
                    System.out.print("de ataque, ");
                    break;
            }
            System.out.print("tem "+calc_idade()+" anos e ");
            aposentar();
        }
    }

    public int calc_idade(){
        LocalDate dataAtual = LocalDate.now();
        //System.out.println(dataAtual);
        int idade = Period.between(this.dataNascimento, dataAtual).getYears();
        return idade;
    }

    public void aposentar(){
        switch(getPosicao()){
            case 1:
                if(40-calc_idade() <= 0){
                    System.out.println("O jogador já se aposentou! ");
                }else{
                    System.out.println("faltam "+ (40-calc_idade()) +" anos para este jogador se aposentar! ");
                }
                break;
            case 2:
                if(38-calc_idade() <= 0){
                    System.out.println("O jogador já se aposentou! ");
                }else{
                    System.out.println("faltam "+ (38-calc_idade()) +" anos para este jogador se aposentar! ");
                }
                break;
            case 3:
                if(35-calc_idade() <= 0){
                    System.out.println("O jogador já se aposentou! ");
                }else{
                    System.out.println("faltam "+ (35-calc_idade()) +" anos para este jogador se aposentar! ");
                }
                break;
        }
    }

    public void menu(){
        System.out.println("-------------------------");
        System.out.println("MENU JOGADOR");
        System.out.println("-------------------------");
        Scanner reader = new Scanner(System.in);
        int cod = 0;
        Player jog = new Player();
        while(cod!=9){  
            System.out.println("OPÇÕES: ");
            System.out.println("-------------------------");
            System.out.println("CADASTRAR NOVO JOGADOR: [1]");
            System.out.println("VER OS DADOS DO JOGADOR: [2]");
            System.out.println("SAIR: [9]");
            System.out.println("-------------------------");
            cod = reader.nextInt();
            switch(cod){
                case 1:
                    System.out.println("Opção selecionada: [1] - CADASTRAR JOGADOR");
                    System.out.print("Digite o nome do novo jogador: ");
                    reader.nextLine();
                    jog.setNome(reader.nextLine());
                    System.out.print("Digite a nacionalidade do novo jogador: ");
                    //reader.nextLine();
                    jog.setNacionalidade(reader.nextLine());
                    do{
                        System.out.print("Digite a data de nascimento do novo jogador: [dd/MM/yyyy] ");
                        String dataNascimentoString = reader.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        try {
                            LocalDate dataNascimento = LocalDate.parse(dataNascimentoString, formatter);
                            jog.setDataNascimento(dataNascimento);
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
                        }
                    }while(jog.getDataNascimento() == null);
                    System.out.print("Digite o peso do novo jogador: ");
                    jog.setPeso(reader.nextFloat());
                    System.out.print("Digite a altura do novo jogador: ");
                    jog.setAltura(reader.nextFloat());
                    do{
                        System.out.print("Digite a posição do jogador: [1-DEFESA/2-MEIO CAMPO/3-ATACANTE] ");
                        jog.setPosicao(reader.nextInt());
                    }while(jog.getPosicao() > 3 || jog.getPosicao() < 1);
                    break;
                case 2:
                    jog.mostrar();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Não há nenhuma função atribuída ao código "+cod+". Tente novamente.");
            }
            System.out.println("-------------------------");
        }

        reader.close();
    }


}
