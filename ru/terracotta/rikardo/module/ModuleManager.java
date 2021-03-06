package ru.terracotta.rikardo.module;

import ru.terracotta.rikardo.module.modules.Combat.AimBot;
import ru.terracotta.rikardo.module.modules.Combat.AntiBot;
import ru.terracotta.rikardo.module.modules.Combat.test;
import ru.terracotta.rikardo.module.modules.misc.*;
import ru.terracotta.rikardo.module.modules.move.AutoSprint;
import ru.terracotta.rikardo.module.modules.move.GuiMove;
import ru.terracotta.rikardo.module.modules.render.*;

import java.util.ArrayList;

public class ModuleManager {

    private ArrayList<Module> modules = new ArrayList<Module>();

    public void init(){
        modules.add(new test());
        modules.add(new Gui());
        modules.add(new ESP());
        modules.add(new AimBot());
        modules.add(new AutoSprint());
        modules.add(new StorageESP());
        modules.add(new AntiBot());
        modules.add(new GuiMove());
        modules.add(new Tracers());
        modules.add(new NameTags());
        modules.add(new ModuleList());
        modules.add(new WaterMark());
        modules.add(new Coords());
        modules.add(new ArrmorHud());
        modules.add(new Xray());
        modules.add(new AutoMine());
        modules.add(new Notifications());
        modules.add(new FreeCam());
        modules.add(new MCF());
        modules.add(new ChinaHat());
        modules.add(new Bright());
        modules.add(new Glowing());
        modules.add(new WallHack());
        modules.add(new NoHurtCam());
        modules.add(new NameProtect());
        modules.add(new Panic());
        modules.add(new VClip());
        modules.add(new Particalse());
        modules.add(new Timer());

    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public ArrayList<Module> getModulesInCategory( Category category) {
        ArrayList<Module> reurns = new ArrayList<Module>();
        for(Module module : modules){
            if(module.getCategory() == category){
                reurns.add(module);
            }
        }
        return reurns;
    }
    public Module getModule(String name){
        for(Module module : modules){
            if(module.getName() == name){
                return module;
            }
        }
        return null;
    }

    public ArrayList<Module> getEnabledModules() {
        ArrayList<Module> reurns = new ArrayList<Module>();
        for(Module module : modules){
            if(module.isEnable()){
                reurns.add(module);
            }
        }
        return reurns;
    }
}
