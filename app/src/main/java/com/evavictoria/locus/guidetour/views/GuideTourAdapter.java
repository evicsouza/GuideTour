
        package com.evavictoria.locus.guidetour.views;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.recyclerview.widget.RecyclerView;

        import com.evavictoria.locus.guidetour.R;
        import com.evavictoria.locus.guidetour.model.PontoTuristico;

        import java.util.ArrayList;
        import java.util.List;

public class GuideTourAdapter extends RecyclerView.Adapter<GuideTourViewHolder> {

    private List<PontoTuristico> pontoTuristicos;

    public GuideTourAdapter(List<PontoTuristico> mPontoTuristico) {
        this.pontoTuristicos = mPontoTuristico;
    }

    @Override
    public GuideTourViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_descricaoponto, viewGroup, false);
        return new GuideTourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GuideTourViewHolder itemViewHolder, int position) {
        final PontoTuristico model = pontoTuristicos.get(position);
        GuideTourViewHolder.bind(model);
    }

    @Override
    public int getItemCount() {
        return pontoTuristicos.size();
    }

    public void setFilter(List<PontoTuristico> countryModels) {
        pontoTuristicos = new ArrayList<>();
        pontoTuristicos.addAll(countryModels);
        notifyDataSetChanged();
    }
}