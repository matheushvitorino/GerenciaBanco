
package com.mycompany.gerenciabanco;

import java.util.Scanner;

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario  usuario = new Usuario("matheus", "Vitorino", "12345678");
        int escolha;

        do {
            exibirMenu();
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Escolha a quantidade que deseja depositar");
                    double valorDeposito = scanner.nextDouble();
                    usuario.depositar(valorDeposito);

                    break;
                case 2:
                    System.out.println("Escolha a quantidade que deseja sacar");
                    double valorSaque = scanner.nextDouble();
                    usuario.sacar(valorSaque);

                    break;
                case 3:
                    System.out.println("Saldo: " + usuario.verificarSaldo());

                    break;
            }

        } while (escolha != 4);
        scanner.close();

    }

    public static void exibirMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Verificar Saldo");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static class Saldo {
        private Double saldo;

        public Double getSaldo() {
            return saldo;
        }

        public void setSaldo(Double saldo) {
            this.saldo = saldo;
        }

        public Saldo(Double saldo) {
            this.saldo = saldo;
        }

        // depositar
        public void depositar(Double saldo) {
            this.saldo += saldo;
        }

        // sacar
        public boolean sacar(Double valor) {
            if (valor <= this.saldo) {
                this.saldo -= valor;
                return true;
            }
            return false;
        }

    }

    public static class Usuario {
        private String nome;
        private String sobrenome;
        private String cpf;
        private Saldo saldo;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        public String getcpf() {
            return cpf;
        }

        public void setCPF(String cpf) {
            this.cpf = cpf;
        }

        public Usuario(String nome, String sobrenome, String cpf) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = new Saldo(0.0);
        }

        // depositar
        public void depositar(Double saldo) {
            this.saldo.depositar(saldo);
        }

        // sacar
        public boolean sacar(Double valor) {
            return this.saldo.sacar(valor);
        }

        public double verificarSaldo() {
            return this.saldo.getSaldo();

        }

    }

}
