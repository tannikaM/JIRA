package com.tannika.jira.model;

import com.tannika.jira.exception.AddMilestoneToModuleException;

import java.util.ArrayList;
import java.util.List;

public class Module {
    private final int id;
    private List<MileStone> mileStones;

    public Module(int id) {
        this.id = id;
        this.mileStones = new ArrayList<MileStone>();
    }

    public int getId() {
        return id;
    }

    public List<MileStone> getMileStones() {
        return mileStones;
    }

    public boolean addMileStone(MileStone mileStone) throws AddMilestoneToModuleException {
        if(mileStone != null){
            this.mileStones.add(mileStone);
            return true;
        }
        else {
            throw new AddMilestoneToModuleException("Milestone is null");
        }
    }
}
