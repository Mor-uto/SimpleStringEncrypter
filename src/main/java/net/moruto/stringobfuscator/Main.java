package net.moruto.stringobfuscator;

public class Main {
    public static void main(String[] args) {
        String obfuscated = Obfuscator.obfuscateString("iam obfuscated");
        System.out.print("Obfuscated: " + obfuscated + "\n");

        String deobfuscated = Obfuscator.deobfuscateString(obfuscated);
        System.out.print("Deobfuscated: " + deobfuscated);

    }
}
