package com.goodreads.goodreads.service;

import com.goodreads.goodreads.command.TvSeriesCommand;
import com.goodreads.goodreads.domain.*;
import com.goodreads.goodreads.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TvSeriesServiceImpl implements TvSeriesService {

    private final TvSeriesRepository tvSeriesRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final CommentRepository commentRepository;
    private final TypeRepository typeRepository;

    @Override
    public List<TvSeries> findAllTvSeries() {
        List<TvSeries> tvSeriesList = tvSeriesRepository.findAll();
        return tvSeriesList;
    }

    @Override
    public List<TvSeries> getLast4TvSeries() {

        List<TvSeries> tvSeriesList = new ArrayList<>();
        List<TvSeries> last4TvSeries = tvSeriesRepository.getLast4TvSeries();

        if(last4TvSeries.size() >= 4){
            for(int i = 0; i < 4; i++){
                tvSeriesList.add(last4TvSeries.get(i));

            }
            return tvSeriesList;
        }
        return last4TvSeries;
    }

    @Override
    public List<TvSeries> getTop5TvSeries() {

        List<TvSeries> topTvSeriesList = new ArrayList<>();
        List<TvSeries> top5TvSeries =tvSeriesRepository.getTop5TvSeries();

        if(top5TvSeries.size()>=5){
            for (int i=0;i<5;i++){
                topTvSeriesList.add(top5TvSeries.get(i));
            }
            return topTvSeriesList;
        }

        return top5TvSeries;
    }

    @Override
    public TvSeries findById(Long id) {

        Optional<TvSeries> tvSeries = tvSeriesRepository.findById(id);

        TvSeries tvSeries1 = tvSeriesRepository.getOne(1L);

        if(tvSeries.isEmpty()==true){
            return tvSeries1;
        }

        TvSeries tvSeries2 = tvSeries.get();
        return tvSeries2;
    }

    @Override
    public void saveTvSeries(TvSeriesCommand tvSeriesCommand, MultipartFile multipartFile) throws IOException {

        TvSeries tvSeries = new TvSeries();

        Actor actor = new Actor();
        actor.setActorName(tvSeriesCommand.getActorName());
        actorRepository.save(actor);
        tvSeries.getTvSeriesActorSet().add(actor);

        Director director = new Director();
        director.setDirectorName(tvSeriesCommand.getDirectorName());
        directorRepository.save(director);
        tvSeries.getTvSeriesDirectorSet().add(director);

        Comment comment = new Comment();
        comment.setDescription(tvSeriesCommand.getCommentDescription());
        commentRepository.save(comment);
        tvSeries.getTvSeriesCommentList().add(comment);

        Type type = new Type();
        type.setTypeName(tvSeriesCommand.getType());
        typeRepository.save(type);
        tvSeries.getTvSeriesTypeSet().add(type);

        tvSeries.setTvSeriesSeason(tvSeriesCommand.getTvSeriesSeason());
        tvSeries.setOver(tvSeriesCommand.getIsOver());
        tvSeries.setImdb(tvSeriesCommand.getImdb());
        tvSeries.setTvSeriesName(tvSeriesCommand.getTvSeriesName());
        tvSeries.setTvSeriesUpdateDate(LocalDate.now());

        tvSeriesCommand.setImage(multipartFile);
        String imageString = Base64.getEncoder().encodeToString(tvSeriesCommand.getImage().getBytes());
        tvSeries.setThumbnail(imageString);

        tvSeriesRepository.save(tvSeries);
    }
}
