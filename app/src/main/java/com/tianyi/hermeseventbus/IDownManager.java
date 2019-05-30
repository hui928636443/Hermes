package com.tianyi.hermeseventbus;


import com.tianyi.hermeseventbus.annotion.ClassId;

/**
 * Created by Administrator on 2018/5/23.
 */
@ClassId("com.tianyi.hermeseventbus.DownManager")
public interface IDownManager  {
    public FileRecord getFileRecord();

    public void setFileRecord(FileRecord fileRecord);

}
