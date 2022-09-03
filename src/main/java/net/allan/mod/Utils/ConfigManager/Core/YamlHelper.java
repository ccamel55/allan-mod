package net.allan.mod.Utils.ConfigManager.Core;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class YamlHelper {

    private Yaml yaml;

    public YamlHelper() {
        final var options = new DumperOptions();

        options.setIndent(2);
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setIndentWithIndicator(true);

        yaml = new Yaml(options);
    }

    public void writeFile(Map<String, Object> yamlData, File file) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            yaml.dump(yamlData, printWriter);
            printWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> readFile(File file) {
        try {
            final var inputStream = new FileInputStream(file);
            Map<String, Object> parsed = yaml.load(inputStream);
            inputStream.close();

            return parsed;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }
}
