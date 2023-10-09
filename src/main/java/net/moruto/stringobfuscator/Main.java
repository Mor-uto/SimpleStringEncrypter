package net.moruto.stringobfuscator;

public class Main {
    public static void main(String[] args) {
        String obfuscated = ObfUtils.obfuscateString("iam obfuscated");
        System.out.print("Obfuscated: " + obfuscated + "\n");

        String deobfuscated = ObfUtils.deobfuscateString(obfuscated);
        System.out.print("Deobfuscated: " + deobfuscated);

    }
}
