package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mrnobody43.shedule_application.R;

import Utils.Constants;
import model.ExamTeacher.ClassExamTeacher;
import model.ExamTeacher.ExamsTeacher;

/**
 * Created by Mr.Nobody43 on 11.04.2018.
 */

public class ExamTeacherAdapter extends BaseAdapter {
    public ExamTeacherAdapter(Context context, ExamsTeacher examTeacher, int day) {
        _ExamsTeacher = examTeacher;
        _indexTab = day;
        _lInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public boolean isNull()
    {
        return _ExamsTeacher == null || _ExamsTeacher.isEmpty();
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return _ExamsTeacher.getAll().get(_indexTab).get_classes().size();}

    // элемент по позиции
    @Override
    public Object getItem(int position) {return _ExamsTeacher.getAll().get(_indexTab).get_classes().get(position);}

    @Override
    public long getItemId(int position) {
        return position;
    }

    private ClassExamTeacher getClass(int position) {
        return ((ClassExamTeacher) getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ClassExamTeacher p = getClass(position);

        if(convertView == null || parent != convertView.getParent()) {
            convertView = _lInflater.inflate(R.layout.schedule_list_exam_teacher_item, parent, false);

            String cnt = Integer.toString(position + 1);
            ((TextView) convertView.findViewById(R.id.id_pair)).setText(cnt);
            ((TextView) convertView.findViewById(R.id.time)).setText(p.get_time());

            if (p.get_subject().get(0).equals(Constants.FREE)) {
                ((TextView) convertView.findViewById(R.id.subject)).setText(Constants.FREE_TIME);
            }
            else {
                ((TextView) convertView.findViewById(R.id.subject)).setText(p.get_subject().get(0) + " " + p.get_type().get(0));

                String groups = "";

                for (int iCnt = 0; iCnt < p.get_groups().get(0).size(); ++iCnt) {
                    groups += p.get_groups().get(0).get(iCnt);
                    if(iCnt <  p.get_groups().get(0).size() - 1) groups += "\n";
                }

                ((TextView) convertView.findViewById(R.id.groups)).setText(groups);
                ((TextView) convertView.findViewById(R.id.classroom)).setText(p.get_classroom().get(0));
            }
        }

        return convertView;
    }

    private LayoutInflater _lInflater;
    private ExamsTeacher _ExamsTeacher;
    private int _indexTab;
}