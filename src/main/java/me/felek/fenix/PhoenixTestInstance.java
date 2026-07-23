package me.felek.fenix;

import java.util.List;

/**
 * @className: PhoenixTestInstance
 * @author: Felek
 * @date: 23.07.2026 14:38
 */

public class PhoenixTestInstance {
    public String name;
    public String install;
    public String folder;
    public List<String> compile;
    public List<String> run;

    @Override
    public String toString() {
        return "PhoenixTestInstance{" +
                "name='" + name + '\'' +
                ", install='" + install + '\'' +
                ", folder='" + folder + '\'' +
                ", compile=" + compile +
                ", run=" + run +
                '}';
    }
}
